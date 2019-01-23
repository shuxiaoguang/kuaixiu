$(function(){
    
    var fm=eCacheUtil.storage.getCache(CacheKey.source);
    if(isEmpty(fm)){
        eCacheUtil.storage.cache(CacheKey.source,GetQueryString('fm'));
    }
    if(fm == 2 || fm == 9 || fm == 10){
        document.title = '天翼回收';
    }else if(fm == 7){
        document.title = '翼回收';
    }else{
		document.title = '超人回收';
	}
    $('h3').html(eCacheUtil.storage.getCache(CacheKey.ModelName));
    //如果产品id为空则跳转到product页面
    if(isEmpty(eCacheUtil.storage.getCache(CacheKey.ProjectId))){
        location.href = 'product.html';
        return;
    }

    var param = {
        productid:eCacheUtil.storage.getCache(CacheKey.ProjectId),
        modelName:eCacheUtil.storage.getCache(CacheKey.ModelName)
    };
    loadData(param);
});
function loadData(param) {
    $.post(linkUrl+"/recycleNew/getCheckList.do",{params:JSON.stringify(param)},function(data){
        if (data.success){
            var s='',
			ss='',
			dataInfo = data.result.datainfo.questions,
			index = 0;
            for (var i = 0;i < dataInfo.length;i++){
				var checkid = dataInfo[i].id;
			    index += 1;
				if(dataInfo[i].questionType == "SINGLECHOISE"){
					s += '<dl data-acc="'+checkid+'">' +
						'<dt>' +(index)+'.'+dataInfo[i].name+
						'<span class="selected-property"></span>' +
						'<i>修改</i>' + '</dt>' + '<dd>';
					var answers = dataInfo[i].answers;
					for (var j = 0;j < answers.length;j++){
						s += '<div class="value-text" data-level="' + answers[j].id+'"><p>' + answers[j].name + '</p>';
						if (isEmpty(answers[j].tips.tipStr)){
							s += '</div>'
						}else {
							s += '<span data-imgs="'+answers[j].tips.picUrl+'"></span></div>';
						   /* if (isEmpty(answers[j].vdescriptionimg[1])){
								s += '<span data-imgs="'+answers[j].vdescriptionimg[0]+'"></span></div>';
							}else {
								s += '<span data-imgs="'+answers[j].vdescriptionimg[0]+'" data-content="'+answers[j].vdescriptionimg[1]+'"></span></div>'
							}*/
						}
					}
					s += '</dd>' + '</dl>';
				}else if(dataInfo[i].questionType == "MULTICHOICES"){
					// '<div data-acc="'+checkid+'">' +
					ss += '<p>' +(index)+'.'+dataInfo[i].name + '</p>'; 
					var answers = dataInfo[i].answers;
					for (var j = 0;j < answers.length;j++){
						ss += '<a href="javascript:;" data-level="' + answers[j].id+'">' + answers[j].name + '</a>';
					}
					//ss += '</div>';
				} 
            }
            $('.select-property.required').html(s);
            $('.select-property.required dl').eq(0).addClass('select');
			
			$('.select-property.notrequired').html(ss);
			
            loading_hide();
            LoadOrNot();
        }else {
            if (data.resultMessage == "未找到产品"){
                location.href = 'error.html';
            }else{
                loading_hide();
                alertTip(data.resultMessage);
            }
        }
    });
}

function LoadOrNot() {
    var isSelected = eCacheUtil.storage.getCache(CacheKey.isSelect);
    if(isSelected == 'true'){
        var str = eCacheUtil.storage.getCache(CacheKey.SelectItems);
        var strs = new Array();
        strs = str.split("|");
        $.each(strs, function (i, n) {
            var index = n.split(','),
                target = $('.required').find('dl').eq(i),
                target1 = $('.notrequired a');
            if (index[0]==target.attr('data-acc')){
                target.find('[data-level="'+index[1]+'"]').addClass('is-lock');
                target.find('.selected-property').html(target.find('.is-lock p').html());
                target.addClass('checked').removeClass('select');
            }else if(i >= $('.required').length){
                for(var j = 0;j<target1.length;j++){
                    if(index[1] == target1.eq(j).attr('data-level')){
                        target1.eq(j).addClass('detection_tabin');
                    }
                }
            } 
			
		  /*  target = $('.required').find('dl').eq(i),
            target1 = $('.notrequired a');
			if(i < $('.required').length){
				for(var k=0;k< $('.required').length;k++){
				  target.find('[data-level="'+ n +'"]').addClass('is-lock');
                  target.find('.selected-property').html(target.find('.is-lock p').html());
                  target.addClass('checked').removeClass('select'); 	
				}
				
			}else{
				for(var j = 0;j<target1.length;j++){
                    if( n == target1.eq(j).attr('data-level')){
                        target1.eq(j).addClass('detection_tabin');
                    }
                }
			}  */
			
        });
		var per=100;
		$('.processbar-cover').css({"width":per+"%","transition":".3s"}).html(per + "%");
		$('.footer #submit').removeClass('disabled');
    }
}

$('.select-property.required').on('click','.value-text',function () {
    //滑动
    $('.mainCont').animate({
        scrollTop:$('dl dt').height()*$('.select').eq($('.select').length-1).index()
    },"fast");
    $(this).addClass('is-lock').siblings().removeClass('is-lock');
    $(this).parents('dl').attr('class','checked');
    $(this).parents('dl').find('span.selected-property').html($(this).find('p').html());
    var nextObj = $(this).parents('dl').next();
    if (!nextObj.hasClass('checked')){
        $(this).parents('dl').next().addClass('select');
    }
    proCessBar();
}).on('click','.checked i',function () {
    $(this).parents('dl').removeClass('checked').addClass('select');
    $(this).prev('.selected-property').empty();
}).on('click','.value-text span',function (e) {
    e.stopPropagation();
    $('.desc img').attr('src',$(this).attr('data-imgs'));
    if (!isEmpty($(this).attr('data-content'))){
        $('.desc').append('<p>'+$(this).attr('data-content')+'</p>');
    }
    $('.tipBox').addClass('active');
});
$('.close a').click(function () {
    $('.tipBox').removeClass('active');
});

/*$('.select-property.notrequired a').click(function() {
    if ($(this).hasClass('detection_tabin')) {
        $(this).removeClass('detection_tabin');
    } else {
        $(this).addClass('detection_tabin');
    }
});*/

$('.main').delegate('.select-property.notrequired a' , 'click' , function( ){
    if ($(this).hasClass('detection_tabin')) {
        $(this).removeClass('detection_tabin');
    } else {
        $(this).addClass('detection_tabin');
    }
});

function proCessBar() {
    var total = $('.select-property.required dl').length;
    var len = $('.select-property.required .checked').length;
    var per = Math.ceil(len / total * 10000/100.00);
    $('.processbar-cover').css({"width":per+"%","transition":".3s"}).html(per + "%");
    // $('.processbar-cover').animate({
    //     width:per+"%"
    // },"fast").html(per + "%");
    if (per == 100){
        $('.footer #submit').removeClass('disabled');
    }
}
$('#submit').click(function () {
    if (!$(this).hasClass('disabled')){
        eCacheUtil.storage.removeCache(CacheKey.prePrice);
        var itemsArr = [[19,75]],items = '';
        $('.checked').each(function (i,e) {
            itemsArr[i]=[$(this).attr('data-acc'),$(this).find('.is-lock').attr('data-level')];
		   // itemsArr[i] = [$(this).find('.is-lock').attr('data-level')];
            items += $(this).find('.selected-property').html()+'、';
        });
       $('.notrequired').children('a').each(function() {
            if ($(this).hasClass('detection_tabin')) {
              //  if ($(this).attr('data-acc') == 21){
               //     itemsArr.push([20,79]);
             //   }
               itemsArr.push([$(this).attr('data-acc'),$(this).attr('data-level')]);
			  // itemsArr.push([$(this).attr('data-level')]);
               items += $(this).html()+'、';
            } else {
              //  if ($(this).attr('data-acc') == 21){
              //      itemsArr.push([20,78]);
              //  }
              //  itemsArr.push([$(this).attr('data-acc'),$(this).attr('default')]);
              // items += $(this).html().replace(/不/g, '')+'、';
            }
        });  
		
        eCacheUtil.storage.cache(CacheKey.SelectItems,itemsArr.join('|'));
        eCacheUtil.storage.cache(CacheKey.itemsName,items.substr(0,items.length-1));
        eCacheUtil.storage.cache(CacheKey.isSelect,true);
		

		location.href = 'result.html';

        
    }
})