/**
 * Created by zxm on 2017/3/31.
 */
$.fn.extend({
    "initPage":function(listCount,currentPage,fun){
        var maxshowpageitem = $(this).attr("maxshowpageitem");
        if(maxshowpageitem!=null&&maxshowpageitem>0&&maxshowpageitem!=""){
            page.maxshowpageitem = maxshowpageitem;
        }
        var pagelistcount = $(this).attr("pagelistcount");
        if(pagelistcount!=null&&pagelistcount>0&&pagelistcount!=""){
            page.pagelistcount = pagelistcount;
        }

        var pageId = $(this).attr("id");
        page.pageId=pageId;
        if(listCount<0){
            listCount = 0;
        }
        if(currentPage<=0){
            currentPage=1;
        }
        page.setPageListCount(pageId,listCount,currentPage,fun);

    }
});
var  page = {
    "maxshowpageitem":5,//最多显示的页码个数
    "pagelistcount":10,//每一页显示的内容条数
    /**
     * 初始化分页界面
     * @param listCount 列表总量
     */
    "initWithUl":function(pageId,listCount,currentPage){

        var pageCount = 1;
        if(listCount>0){
             pageCount = listCount%page.pagelistcount>0?parseInt(listCount/page.pagelistcount)+1:parseInt(listCount/page.pagelistcount);
        }
        var appendStr = page.getPageListModel(pageCount,currentPage);
        $("#"+pageId).html(appendStr);
    },
    /**
     * 设置列表总量和当前页码
     * @param listCount 列表总量
     * @param currentPage 当前页码
     */
    "setPageListCount":function(pageId,listCount,currentPage,fun){
        listCount = parseInt(listCount);
        currentPage = parseInt(currentPage);
        page.initWithUl(pageId,listCount,currentPage);
        page.initPageEvent(pageId,listCount,fun);

    },
    "initPageEvent":function(pageId,listCount,fun){
        $("#"+pageId +">li[class='pageItem']").on("click",function(){
            if(typeof fun == "function"){
                fun($(this).attr("page-data"));
            }
            page.setPageListCount(pageId,listCount,$(this).attr("page-data"),fun);
        });
        $("#ChangeNum").on("change",function(){
            var pageCount = 1;
            if(listCount>0){
                pageCount = listCount%page.pagelistcount>0?parseInt(listCount/page.pagelistcount)+1:parseInt(listCount/page.pagelistcount);
            }
            var changeNum = parseInt($("#ChangeNum").val());
            if (typeof changeNum != "NaN" && changeNum > 0 && changeNum <= pageCount) {
                if(typeof fun == "function"){
                    fun(changeNum);
                }
                page.setPageListCount(pageId,listCount,changeNum,fun);
            }else {
                $("#ChangeNum").val("");
                layer.msg("请输入正确的页码", {time: 1000})
            }

        });
    },
    "getPageListModel":function(pageCount,currentPage){
        var prePage = currentPage-1;
        var nextPage = currentPage+1;
        var prePageClass ="pageItem";
        var nextPageClass = "pageItem";
        if(prePage<=0){
            prePageClass="pageItem disabled";
        }
        if(nextPage>pageCount){
            nextPageClass="pageItem disabled"
        }
        var appendStr ="";
        appendStr+="<li title='"+$lang['first_page']+"' id='home' page-data='1' class='"+prePageClass+"'><a><img id='imageOne'></a></li>";
        appendStr+="<li title='"+$lang['prev_page']+"' page-data='"+prePage+"' class='"+prePageClass+"'><a><img id='imageTwo'></a></li>";
        var miniPageNumber = 1;
        if(currentPage-parseInt(page.maxshowpageitem/2)>0&&currentPage+parseInt(page.maxshowpageitem/2)<=pageCount){
            miniPageNumber = currentPage-parseInt(page.maxshowpageitem/2);
        }else if(currentPage-parseInt(page.maxshowpageitem/2)>0&&currentPage+parseInt(page.maxshowpageitem/2)>pageCount){
            miniPageNumber = pageCount-page.maxshowpageitem+1;
            if(miniPageNumber<=0){
                miniPageNumber=1;
            }
        }
        var showPageNum = parseInt(page.maxshowpageitem);
        if(pageCount<=showPageNum){
            for(var i=0;i<pageCount;i++){
                var pageNumber = miniPageNumber++;
                var itemPageClass = "pageItem";
                if(pageNumber==currentPage){
                    itemPageClass = "pageItem active";
                }
                appendStr+="<li id='"+pageNumber+"' page-data='"+pageNumber+"' page-rel='itempage' class='"+itemPageClass+"' ><a class='ng-star-inserted'>"+pageNumber+"</a></li>";
            }
        }else {
            var firstPageNum = 0;
            for(var i=0;i<showPageNum - 1 ;i++){
                var pageNumber = miniPageNumber++;
                if (i == 0){
                    firstPageNum = pageNumber;
                }
                var itemPageClass = "pageItem";
                if(pageNumber==currentPage ){
                    itemPageClass = "pageItem active";
                }
                appendStr+="<li id='"+pageNumber+"' page-data='"+pageNumber+"' page-rel='itempage' class='"+itemPageClass+"' ><a class='ng-star-inserted'>"+pageNumber+"</a></li>";
            }
            if ((pageCount - firstPageNum + 1) != showPageNum){
                appendStr+="<li class='pageEllipsis'><a class='ng-star-inserted'>···</a></li>";
            }
            var itemPageClass = "pageItem";
            if (pageCount == currentPage){
                itemPageClass = "pageItem active";
            }
            appendStr+="<li id='"+pageCount+"' page-data='"+pageCount+"' page-rel='itempage' class='"+itemPageClass+"' ><a class='ng-star-inserted'>"+pageCount+"</a></li>";
        }

        appendStr+="<li title='"+$lang['next_page']+"' page-data='"+nextPage+"' class='"+nextPageClass+"'><a><img id='imageThree'></a></li>";
        appendStr+="<li title='"+$lang['last_page']+"' id='tail' page-data='"+pageCount+"' class='"+nextPageClass+"'><a><img id='imageFour'></a></li>";
        appendStr+="<li class='lastToNum'><span>" + $lang['go_to'] + "</span><input type='text' id='ChangeNum'><span id='sureInfo' class='num'>"+$lang['page_num']+"</span></li>";
        return appendStr;

    }
}