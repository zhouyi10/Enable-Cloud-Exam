var errorQuestionIndex = window.errorQuestionIndex = {
    queryParam:{offset:0,limit:10},
    queryUrl:'',
    countUrl:'',
    currentPage: 1,
    teachGroups: [],
    searchCodes: [],
    init:function(){
        $(".navLi").removeClass("activeLi");
        $("#errorQuestion").addClass("activeLi");
        this.initErrorQuestion();
    },
    initErrorQuestion: function (){
        if (this.teachGroups.length > 0) {
            $("#class-select").find("option").eq(1).prop("selected",true)
        }
        this.getErrorQuestionData();
    },
    getErrorQuestionData:function (){
        var index = layer.load(1, {
            shade: [0.3,'#000']
        });
        this.queryParam.searchCodes = this.searchCodes;
        this.queryParam.classIds = [];
        $(".stepList").html("");
        var _this = this;
        let classVal = $("#class-select").val();
        let classIds =[];
        if (classVal == 'all') {
            _this.teachGroups.forEach(item => {
                classIds.push(item.classId);
            });
        }else{
            classIds.push(classVal);
        }
        this.queryParam.classIds = classIds;
        var completeFlag = 0;
        $.ajax({
            type:'POST',
            url:_this.queryUrl,
            contentType: "application/json",
            data: JSON.stringify(_this.queryParam),
            dataType: "json",
            async:true,
            success:function(result){
                if (null != result && result.length > 0) {
                    result.forEach((item,index) => {
                        let notMaster = item["notMasterCount"] + "/" + item["questionCount"];
                        let unmarkedCause = item["unmarkedCauseCount"] + "/" + item["questionCount"];
                        let orderNumber = _this.queryParam.offset * _this.queryParam.limit + index + 1;
                        let questionContent = '<div class="questionBox ng-star-inserted">\n' +
                            '                                <div class="li_question">\n' +
                            item["questionContent"] +
                            '                                </div>\n' +
                            '                                <div class="li_index">\n' +
                            '                                    <div class="num">'+ orderNumber +'</div>\n' +
                            '                                    <div class="info">\n' +
                            '                                        <div class="content">\n' +
                            '                                            <div>????????????:' + notMaster + '</div>\n' +
                            '                                            |\n' +
                            '                                            <div>????????????:' + unmarkedCause +'</div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                            </div>';
                        $(".stepList").append($(questionContent));
                    });
                }else{
                    let nodataHtml = '<div class="no-data">?????????????????????!</div>';
                    $(".stepList").append($(nodataHtml));
                }
            },error:function (r){
            },complete:function (c){
                completeFlag++;
                if (completeFlag > 1) {
                    layer.close(index);
                }
            }
        });

        $.ajax({
            type:'POST',
            url:_this.countUrl,
            contentType: "application/json",
            data: JSON.stringify(_this.queryParam),
            dataType: "json",
            async:true,
            success:function(result){
                if (result > 0) {
                    let pages = Math.ceil(result/10);
                    let pageInfo = "???" + pages + "???/" + result + "???";
                    $("#pageInfo").text(pageInfo);
                }else{
                    $("#pageInfo").text("");
                }

                $("#pageOne").initPage(result, _this.currentPage, function (pageNum) {//1?????????????????????????????????????????????2?????????????????????????????? 3??????????????????
                    _this.queryParam.offset=(pageNum - 1) * 10;
                    _this.currentPage = pageNum;
                    _this.getErrorQuestionData();
                });

            },error:function (r){
            },complete:function (c){
                completeFlag++;
                if (completeFlag > 1) {
                    layer.close(index);
                }

            }
        });

    }
};


$(function(){
    $("#class-select").change(function (event){
        errorQuestionIndex.currentPage = 1;
        errorQuestionIndex.queryParam.offset = 0;
        errorQuestionIndex.getErrorQuestionData();
    });
});



function ztreeCall(obj){
    errorQuestionIndex.searchCodes = [];
    if (!obj == false){
        var treeNode = $('#knowledgeTree').jstree(true).get_checked(true);
        treeNode.forEach(item => {
            errorQuestionIndex.searchCodes.push(item['original']['searchCode']);
        });
    }
    errorQuestionIndex.currentPage = 1;
    errorQuestionIndex.queryParam.offset = 0;
    errorQuestionIndex.getErrorQuestionData();

}

