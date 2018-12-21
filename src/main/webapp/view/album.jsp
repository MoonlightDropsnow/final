<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-tip',
            text: "专辑详情",
            handler: function () {
                //https://www.cnblogs.com/nuccch/p/7151228.html
                $("#albumBriefDialog").dialog("open");
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-add',
            handler: function () {
                alert("添加专辑");
            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-add',
            handler: function () {
             alert("添加章节");
            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-save',
            handler: function () {
                alert("下载音频");
            }
        }]
        $('#albumDatagrid').treegrid({
            method:"get",
            url:'${pageContext.request.contextPath}/album/allAlbumsThisPage',
            idField:'id',
            treeField:'title',
            columns:[[
                {field:'title',title:'名称',width:60},
                {field:'size',title:'大小',width:40,formatter:function (value) {
                        if(!isNaN(value)){
                        return value+"MB";
                        }
                    }},
                {field:'time',title:'时长',width:40,formatter:function (value) {
                        if(!isNaN(value)) {
                            return value + "分钟";
                        }
                    }},
                {field:'url',title:'路径',width:80},
                {field:'uploadDate',title:'上传时间',width:80},
                {field:'listen',title:'播放',width:100,formatter:function (value,rows) {
                        if(rows.url){
                            return "<audio controls='controls' src='${pageContext.request.contextPath}/"+rows.url+"'/>";
                        }
                    }}
            ]],
            fitColumns:true,
            toolbar:toolbar,
            pagination:true,
            pageSize:3,
            pageList:[3,6,9],
            onLoadSuccess:function () {
                $("#albumDatagrid").treegrid("collapseAll");
            }
        });
        //添加
        $("#albumBriefDialog").dialog({
            title: '专辑详情',
            width: 400,
            height: 260,
            closed: true,
            cache: false,
            href: '${pageContext.request.contextPath}/view/albumDetails.jsp',
            modal: true
        });

    })
</script>


<div>
    <table id="albumDatagrid">

    </table>
</div>
<div id="albumBriefDialog" align="center">
</div>
