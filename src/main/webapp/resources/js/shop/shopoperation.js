/**
 * 获取初始信息，填充至前台html控件
 * 点击提交，将表单内容转发至后台
 */
$(function () {
    //获取店铺初始化信息（分类，区域信息）
    var initUrl = 'o2o/shopadmin/getshopinitinfo';

    //注册店铺
    var registerShopUrl = 'o2o/shopadmin/registershop';
    alert(initUrl);
    getShopInitInfo();

    function getShopInitInfo() {
        $getJSON(initUrl,function (data) {
            if(data.success){
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function(item,index){
                    tempHtml += '<option data-id="' + item.shopCategoryId
                        + '">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });
        $('#submit').click(function(){
            var shop = {};
            shop.shopName = $('#shop-name').val();
            shop.shopAddr = $('#shop-addr').val();
            shop.phone = $('#shop-phone').val();
            shop.shopDesc = $('#shop-desc').val();

            shop.shopCategory = {
                shopCategoryId : $('#shop-category').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            shop.area = {
                areaId : $('#area').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            var shopImg = $("#shop-img")[0].files[0];
            var formData = new FormData();
            formData.append('shopImg', shopImg);
            formData.append('shopStr', JSON.stringify(shop));
            $.ajax({
                url : registerShopUrl,
                type : 'POST',
                // contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data : formData,
                contentType : false,
                processData : false,
                cache : false,
                success : function(data) {
                    if (data.success) {
                        $.toast('提交成功！');
                        // if (isEdit){
                        //     $('#captcha_img').click();
                        // } else{
                        //     window.location.href="/shop/shoplist";
                        // }
                    } else {
                        $.toast('提交失败！');
                        $('#captcha_img').click();
                    }
                }
            });
        });
    }
})