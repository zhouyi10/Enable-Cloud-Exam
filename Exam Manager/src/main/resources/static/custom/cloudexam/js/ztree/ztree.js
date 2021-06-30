var KnowledgeTree = window.KnowledgeTree = {
    init : function (url) {
        var _this = this;
        if ($('#knowledgeTree').jstree(true) != false) {
            $('#knowledgeTree').jstree(true).destroy();
            _this.knowledgeSetting.core.data = [];
        }
        var getZtreeUrl =url+"/paper/knowledge/query";
        $.ajax({
            type:'GET',
            url:getZtreeUrl,
            async:true,
            success:function(result){
                var select1 = document.getElementById("classMap");
                if (select1 != undefined && select1 != null) {
                    select1.style.width = "150px";
                    var option = document.createElement("option");// 创建option元素
                    option.appendChild(document.createTextNode("全部"));
                    option.setAttribute("value", "all");
                    select1.appendChild(option);
                }
                _this.initTree(_this.convertData(result.knowledgeInfos));
                var teacherBaseInfo = result.teacherBaseInfo;
                if(teacherBaseInfo != "" && teacherBaseInfo != null && teacherBaseInfo != undefined){ // "",null,undefined
                    $('#sore').text(teacherBaseInfo.stageName+teacherBaseInfo.gradeName+teacherBaseInfo.subjectName+teacherBaseInfo.materialVersion.name+teacherBaseInfo.termName);
                    var classMap = teacherBaseInfo.classMap;
                    console.log("classMap"+classMap)
                    /*classMap.put("0","全部")*/
                        for (var key in classMap) {
                            var select = document.getElementById("classMap");
                            if (select != undefined && select != null) {
                                var option = document.createElement("option");// 创建option元素
                                option.appendChild(document.createTextNode(classMap[key]));
                                option.setAttribute("value", key);
                                select.appendChild(option);
                            }
                        }

                }
                if(result.knowledgeInfos.length){
                    $('#notTree').hide()
                }
            },error:function (r){
            }
        });
        //_this.initTree(_this.convertData(data));
    },
    initTree : function(treeData){
        var _this = this;
        _this.knowledgeSetting.core.data = treeData;
        $('#knowledgeTree').on('changed.jstree',function(e, data){
          ///$('#knowledgeTree').on('loaded.jstree',function(e, data){
           /* if (!CommUtils.isEmpty(serchcodeList)) {
                $.each(serchcodeList, function(i, knowledgeId){
                    $('#knowledgeTree').jstree(true).select_node(knowledgeId);
                });
            }*/
            //var treeNode = $('#knowledgeTree').jstree(true).get_selected(true);
           // console.log("treeNode"+treeNode);
            //if (data.selected.length) {
                var  index = data.selected.length-1;
                console.log(index);
                //alert(data.instance.get_node(data.selected[0]));
                var json = data.instance.get_node(data.selected[index]);
                if(json !=null && json != undefined){
                    var str = JSON.stringify(json)
                    var obj = JSON.parse(str);
                    _this.ztreeclick(ztreeCall,obj);
                }else {
                    _this.ztreeclick(ztreeCall,null);
                }

               /* console.log("searchCode:"+obj.original.searchCode+"------"+"gradeCode:"+obj.original.gradeCode
                    +"------"+"subjectCode:"+obj.original.subjectCode
                    +"------"+"materialVersion:"+obj.original.materialVersion
                );*/
            //}
        }).jstree(_this.knowledgeSetting);
    },
    convertData : function(data) {
        return $.map(data, function(item){
            var newItem = {
                'id' : item.knowledgeId,
                'parent' : item.parentId == null ? '#' : item.parentId,
                'text' : item.knowledgeName,
                'knowledgeId' : item.knowledgeId,
                'knowledgeName' : item.knowledgeName,
                'materialVersion' : item.materialVersion,
                'materialVersionName' : item.materialVersionName || '',
                'searchCode' : item.searchCode,
                'gradeCode' : item.gradeCode,
                'subjectCode' : item.subjectCode,
                'materialVersion' : item.materialVersion,
                'outlineId' : item.outlineSearchCode,
                'a_attr' : {
                    'title' : item.knowledgeName
                }
            }
            return newItem;
        });
    },
    getKnowledge : function() {
        if ($('#knowledgeTree').jstree(true) == false) {
            return [];
        }
        var checkedNodes = $('#knowledgeTree').jstree(true).get_checked(true);
        var array = [];
        $.each(checkedNodes, function(i, node){
            var knowledge = CommUtils.clone(node.original);
            delete knowledge['id'];
            delete knowledge['text'];
            delete knowledge['a_attr'];
            delete knowledge['parent'];
            array.push(knowledge);
        });
        return array;
    },
    knowledgeSetting : {
        'plugins': ["wholerow", "checkbox","types", "changed"],
        'checkbox': {
            "three_state" : false
        },
            'core': {
            "multiple": true,
            "themes" : {
                "responsive": false
            },
            "check_callback" : true,
            'data': []
        },
        "types" :{
            "default" : {
                "icon" : "fa fa-folder icon-state-warning icon-lg"
            },
            "file" : {
                "icon" : "fa fa-file icon-state-warning icon-lg"
            }
        }
    },
    /*ztreeCallBack : function(callback,str) {
        this.callback(str);
    },*/

/*
     ztreeCallBack:function(obj){
         obj(); //此处的意思是，用callback来替换obj，所以实现为callback(i,obj[i]),正好将数组遍历;
     }
*/

    ztreeclick:function(callback,params){
        callback(params);
    }

}
