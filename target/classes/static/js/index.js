layui.use(['form','layer','jquery','laypage'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;

    $.ajax({
        url: "/open/home",
        // url:"",
        type: "POST",
        async : true,
        success: function(data){
            var obj = data.data;

            // banner
            $('#banner1').attr('src', '/images/数据.png');
            // $('#banner2').attr('src', '/images/图片3.png');
            $('#banner2').attr('src', '/images/公司标.png');
            // $('#banner1').attr('src', obj.banners[0].imgOptions);
            // $('#banner2').attr('src', obj.banners[1].imgOptions);

            // 联系方式
            $('#address').html('<h4>办公地址</h4><p> ' + '成都市高新区府城大道399号天府新谷8号楼' + '</p>');
            $('#phoneemail').html('<h4>联系方式</h4> <p> Phone: ' + '18008085420' +
                ' <br><p>'+'Email : 11111@qq.com '+'</p>');
            $('#qqwx').html('<h4>社交通讯</h4> <p> QQ: ' + '123456789' + ' <br> 微信 : ' + '123456789' + '</p>');
            $('#ownership').html('<h4>版权信息</h4> <p>© 2019 ' + '拾星云科技成都有限公司' + ' 保留所有权利</p>');
            // $('#address').html('<h4>办公地址</h4><p> ' + obj.contacts[0].address + '</p>');
            // $('#phoneemail').html('<h4>联系方式</h4> <p> Phone: ' + obj.contacts[0].phone +
            //     ' <br>Email : <a href=' + obj.contacts[0].email + '> ' + obj.contacts[0].email + ' </a></p>');
            // $('#qqwx').html('<h4>社交通讯</h4> <p> QQ: ' + obj.contacts[0].qq + ' <br> 微信 : ' + obj.contacts[0].wx + '</p>');
            // $('#ownership').html('<h4>版权信息</h4> <p>© 2018 ' + obj.contacts[0].ownership + ' 保留所有权利</p>');

            // 简介
            $('#titleBrief').html('<h4>'+ '拾星云科技成都有限公司' +'</h4> ' +
                '<p>' + '我们的宗旨是研发、生产和销售那些在创新、技术还是设计方面都属于优秀水平的产品。\n' +'</p>'+
                '\n' +
                '<p>'+'我们与客户紧密合作“从点子直至成品”，实践证明这是实现双赢的正确策略，我们向您提供符合您期望、技术成熟、经济实惠的产品解决方案。为了实现您的要求，我们富有经验的专业团队非常乐意随时为您服务。\n' + '</p>'+
                '\n' +
                '<p>'+ '对于产品适用领域的只是、以市场为导向的研发、高技术的专业人员，甄选的供应商，保证了我们为您的特殊应用制造出高品质产品，同时为我们产品和五福的高质量和安全标准提供了保证。\n' +'</p>'+
                '\n' +
                '<p>'+ '无论是现在是未来，我们都支持客户的产品以市场为导向、长信的产品解决方案。作为您的合作伙伴，我们很愿意和您一起为满足未来的要求寻找满意的解决方案。' + '</p>');
            $('#trademark').html('<h5>'+ '优秀产品历史' +'</h5> ' +
                '<ul> ' +
                '<li><span >' + '建研BIM云项目' + '</span></li><br/> ' +
                '<li><span >' + '重庆中冶资源审批项目' + '</span></li><br/> ' +
                '<li><span >' + '西南电力排塔项目' + '</span></li><br/> ' +
                '<li><span >' + '中建4局人员管理项目' + '</span></li><br/> ' +
                '<li><span >' + '四川华西6建族库项目' + '</span></li><br/> ' +
                '<li><span >' + '垒知云课堂' + '</span></li><br/> ' +
                '</ul>'
            );
            $('#marketing').html('<h5>'+ '我们的服务项目' +'</h5> ' +
                '<ul> ' +
                '<li><span >' + 'BS端web应用研发（官网、管理系统等）' + '</span></li><br/> ' +
                '<li><span >' + '移动端小程序/app的应用研发' + '</span></li><br/> ' +
                '<li><span >' + '数据迁移上云服务' + '</span></li><br/> ' +
                '<li><span >' + '老旧项目运维服务' + '</span></li><br/> ' +
                '</ul>'
            );
            // $('#titleBrief').html('<h4>'+ obj.presentation.title +'</h4> <p>' + obj.presentation.brief + '</p>');
            // $('#trademark').html('<h5>'+ obj.presentation.trademark +'</h5> ' +
            //     '<ul> ' +
            //         '<li><span >' + obj.presentation.trademarkSmallLabel1 + '</span></li><br/> ' +
            //         '<li><span >' + obj.presentation.trademarkSmallLabel2 + '</span></li><br/> ' +
            //         '<li><span >' + obj.presentation.trademarkSmallLabel3 + '</span></li><br/> ' +
            //         '<li><span >' + obj.presentation.trademarkSmallLabel4 + '</span></li><br/> ' +
            //     '</ul>'
            // );
            // $('#marketing').html('<h5>'+ obj.presentation.marketing +'</h5> ' +
            //     '<ul> ' +
            //         '<li><span >' + obj.presentation.marketingSmallLabel1 + '</span></li><br/> ' +
            //         '<li><span >' + obj.presentation.marketingSmallLabel2 + '</span></li><br/> ' +
            //         '<li><span >' + obj.presentation.marketingSmallLabel3 + '</span></li><br/> ' +
            //         '<li><span >' + obj.presentation.marketingSmallLabel4 + '</span></li><br/> ' +
            //     '</ul>'
            // );

            var article = obj.article;
            var articleHtml = '';
            for (var i = 0;i < article.length;i++) {
                var imgOptions = article[i].imgOptions;
                var imgOption;
                if (imgOptions != null){
                    var option = imgOptions.split(",");
                    for (var k = 0; k < option.length;k++) {
                        var extStart = option[k].lastIndexOf('.');
                        var ext = option[k].substring(extStart, option[k].length).toUpperCase();
                        if (ext == '.PNG' || ext == '.JPG' || ext == '.JPEG' || ext == '.GIF') {
                            imgOption = option[k];
                            break;
                        }
                    }
                }

                articleHtml +='<div class="col-sm-6 portfolio-item"> <a href=/details?id='+ article[i].id +' class="portfolio-link">' +
                    '                <div class="caption">' +
                    '                <div class="caption-content">' +
                    '                <h3>'+ article[i].title +'</h3>' +
                    '            </div>' +
                    '            </div>' +
                    '            <img src='+ imgOption +' class="img-responsive" alt=""> </a> </div>';
            }

            $('#article').html(articleHtml);

            form.render();
        }
    });
});
