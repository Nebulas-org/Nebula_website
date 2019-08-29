package com.gsac.nebulas.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.gsac.nebulas.config.Constant;
import com.gsac.nebulas.model.Sm;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * 图床上传工具
 *
 * @author YI
 * @date 2019-1-11 09:32:10
 */
public class SmUtil {
    /**
     * @param multipartFile 表单名称。上传图片用到
     * @param ssl           是否使用 https 输出，强制开启
     * @param format        输出的格式。可选值有 json、xml。默认为 json
     * @return
     */
    public static Sm saveFile(MultipartFile multipartFile, boolean ssl, String format) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("smfile", getFile(multipartFile));
        map.put("ssl", ssl);
        map.put("format", format);

        String smStr = HttpUtil.post(Constant.SM_URL, map);

        return JSONUtil.toBean(smStr, Sm.class);
    }

    /**
     * @param multipartFile 表单名称。上传图片用到
     * @param format        输出的格式。可选值有 json、xml。默认为 json
     * @return
     */
    public static Sm saveFile(MultipartFile multipartFile, String format) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("smfile", getFile(multipartFile));
        map.put("format", format);

        String smStr = HttpUtil.post(Constant.SM_URL, map);

        return JSONUtil.toBean(smStr, Sm.class);
    }

    /**
     * @param multipartFile 表单名称。上传图片用到
     * @param ssl           是否使用 https 输出，强制开启
     * @return
     */
    public static Sm saveFile(MultipartFile multipartFile, boolean ssl) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("smfile", getFile(multipartFile));
        map.put("ssl", ssl);

        String smStr = HttpUtil.post(Constant.SM_URL, map);

        return JSONUtil.toBean(smStr, Sm.class);
    }

    /**
     * @param multipartFile 表单名称。上传图片用到
     * @return
     */
    public static Sm saveFile(MultipartFile multipartFile) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("smfile", getFile(multipartFile));

        String smStr = HttpUtil.post(Constant.SM_URL, map);

        return JSONUtil.toBean(smStr, Sm.class);
    }

    public static File getFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getName());
        try {
            FileUtil.writeFromStream(multipartFile.getInputStream(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static Sm savePic(MultipartFile multipartFile, String type) {
        FileOutputStream out = null;
        String path = null;
        Sm sm = null;
        File newFile;
        try {
            byte[] bytes = multipartFile.getBytes();
            if (isWindows()) {
                path = Constant.WINPATH + Constant.WINLEVEL + type;
                newFile = new File(path);
                if (!newFile.exists()) {
                    newFile.mkdirs();
                    path = path + Constant.WINLEVEL + multipartFile.getOriginalFilename();
                    newFile = new File(path);
                } else {
                    path = path + Constant.WINLEVEL + multipartFile.getOriginalFilename();
                    newFile = new File(path);
                }
            } else {
                newFile = new File(path);
                path = Constant.LINUXPATH + Constant.LINUXLEVEL + type;
                if (!newFile.exists()) {
                    newFile.mkdirs();
                    path = path + Constant.LINUXLEVEL + multipartFile.getOriginalFilename();
                    newFile = new File(path);
                } else {
                    path = path + Constant.LINUXLEVEL + multipartFile.getOriginalFilename();
                    newFile = new File(path);
                }
            }
            if (!newFile.exists()) {
                out = new FileOutputStream(path);
                out.write(bytes);
                out.flush();
                out.close();
                sm = Sm.builder().code(Constant.SUCCESS).data(LocalDateTime.now()).msg(Constant.SUCCESSUPLOAD).path(path).build();
            } else {
                sm = Sm.builder().code(Constant.FAILED).data(LocalDateTime.now()).msg(Constant.FILEREADY).path(path).build();
            }
        } catch (IOException e) {
            sm = Sm.builder().code(Constant.FAILED).data(LocalDateTime.now()).msg(Constant.UPLOADFAILED + e.getMessage()).path(path).build();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sm;
    }

    /**
     * 验证当前运行系统
     *
     * @return
     */
    public static boolean isWindows() {
        boolean bool = false;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith(Constant.WINDOWS)) {
            bool = true;
        }
        return bool;
    }
}
