<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf" style="width: 100%;">
        <strong class="am-text-primary am-text-lg">回收订单管理</strong> /
        <small>列表查询</small>
    </div>
</div>

<hr>

<div class="am-g">
    <form id="searchForm" class="form form-horizontal">
        <table id="searchTable">
            <tr>
                <td class="search_th"><label class="control-label">创 建 时 间 ：</label></td>
                <td class="search_td">
                    <div class="am-datepicker-date">
                        <input type="text" id="query_startTime" name="query_startTime"
                               class="form-control am-datepicker-start" data-am-datepicker readonly>
                        <span style="float: left; line-height: 30px; height: 30px; width: 10%; text-align: center;">至</span>
                        <input type="text" id="query_endTime" name="query_endTime"
                               class="form-control am-datepicker-end" data-am-datepicker readonly>
                    </div>
                </td>

                <td class="search_th"><label class="control-label">检测手机号：</label></td>
                <td class="search_td"><input type="text" name="mobile" class="form-control"></td>
            </tr>

            <tr>
                <td class="search_th"><label class="control-label">品 牌 ：</label></td>
                <td class="search_td">
                    <select name="brandId" class="form-control-inline" style="width: 420px;"
                            onchange="brandChange(this.value);">
                        <option value="">--请选择--</option>
                        <c:forEach items="${brands}" var="item" varStatus="i">
                            <option value="${item.brandid }">${item.brandname}</option>
                        </c:forEach>
                    </select>
                </td>
                <td class="search_th"><label class="control-label">机 型 ：</label></td>
                <td class="search_td">
                    <select id="modelId" name="productId" style="width: 420px;" class="form-control-inline">
                        <option value="">--请选择--</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td class="search_th"><label class="control-label">检测渠道 ：</label></td>
                <td class="search_td">
                    <select name="channel" class="form-control">
                        <option value="">--请选择--</option>
                        <c:forEach items="${systems}" var="item" varStatus="i">
                            <option value="${item.id }">${item.name}</option>
                        </c:forEach>
                    </select>
                </td>

                <td class="search_th"><label class="control-label">是否成单 ：</label></td>
                <td class="search_td">
                    <select name="isOrder" class="form-control">
                        <option value="">--请选择--</option>
                        <option value="0">是</option>
                        <option value="1">否</option>
                    </select>
                </td>
            </tr>

            <tr>

                <td class="search_th"><label class="control-label">是否回访 ：</label></td>
                <td class="search_td">
                    <select name="isVisit" class="form-control">
                        <option value="">--请选择--</option>
                        <option value="0">是</option>
                        <option value="1">否</option>
                    </select>
                </td>
            </tr>


        </table>
        <div class="form-group">
            <div class="am-u-sm-12 am-u-md-6">
                <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-sm m20">
                        <button onclick="refreshPage();" class="am-btn am-btn-default search_btn" type="button"> 搜 索
                        </button>
                        <c:if test="${userId eq 'kf018'||userId eq'admin'}">
                            <button onclick="expDataExcel();" type="button" class="am-btn am-btn-default"><span
                                    class="am-icon-file-excel-o"></span> 导出
                            </button>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="am-g">
    <div class="am-u-sm-12">
        <table id="dt" class="table table-striped table-bordered table-radius table-hover">
            <thead>
            <tr>
                <th class="fontWeight_normal tdwidth50"><input id="check_all_btn" onclick="checkAll(this)"
                                                               type="checkbox"/>序号
                </th>
                <th class="fontWeight_normal table-title">创建时间</th>
                <th class="fontWeight_normal table-title">品牌</th>
                <th class="fontWeight_normal table-title">机型</th>
                <th class="fontWeight_normal tdwidth300">检测项目</th>
                <th class="fontWeight_normal table-title">报价（元）</th>
                <th class="fontWeight_normal table-title">检测手机号</th>
                <th class="fontWeight_normal table-title">检测渠道</th>
                <th class="fontWeight_normal table-title">成单</th>
                <th class="fontWeight_normal table-title">回访情况</th>
                <th class="fontWeight_normal table-title">操作</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    /**
     * 查看模型
     */
    function brandChange(id) {
        $("#modelId option[value!='']").remove();
        if (id) {
            var url = AppConfig.ctx + "/recycle/testGetModels.do";
            $.get(url, {brandId: id}, function (result) {
                if (!result.success) {
                    return false;
                }
                var json = result.result;
                var select_html = '';
                if (json.length > 0) {
                    for (a in json) {
                        select_html += '<option value="' + json[a]['productid'] + '">' + json[a]['modelname'] + '</option>';
                    }
                }
                $("#modelId").append(select_html);
            });
        }
    }

    $("#query_startTime").datetimepicker({
        format: "yyyy-mm-dd",
        language: "zh-CN",
        autoclose: true,//选中关闭
        minView: "month"//设置只显示到月份
    });

    $("#query_endTime").datetimepicker({
        format: "yyyy-mm-dd",
        language: "zh-CN",
        autoclose: true,//选中关闭
        minView: "month"//设置只显示到月份
    });
    //自定义datatable的数据
    var dto = new DtOptions();
    //设置数据刷新路径
    dto.ajax = {
        "url": "${ctx}/recycle/testListForPage.do",
        "data": function (d) {
            //将表单中的查询条件追加到请求参数中
            var array = $("#searchForm").serializeArray();
            $.each(array, function () {
                d[this.name] = this.value;
            });
        }
    };

    //设置数据列
    dto.setColumns([
        {"data": "id", "class": " center"},
        {"data": "createTime", "class": ""},
        {"data": "brand", "class": ""},
        {"data": "model", "class": ""},
        {"data": "product_name", "class": ""},
        {"data": "price", "class": ""},
        {"data": "login_mobile", "class": ""},
        {"data": "name", "class": ""},
        {"data": "recycle_id", "class": ""},
        {"data": "test_id", "class": ""},
        {"defaultContent": "操作", "class": ""}
    ]);
    //设置定义列的初始属性
    dto.setColumnDefs([
        {//复选框
            targets: 0,
            render: function (data, type, row, meta) {
                var context = {
                    func: [
                        {"id": row.id, "order": meta.row + 1}
                    ]
                };
                var html = template_chk(context);
                return html;
            }
        },
        {
            targets: -4,
            render: function (data, type, row, meta) {
                if (row.name == null) {
                    return "集团欢GO抽奖";
                } else {
                    return row.name;
                }

            }
        },
        {
            targets: -3,
            render: function (data, type, row, meta) {
                if (row.recycle_id == null || row.recycle_id == "") {
                    return "否";
                } else {
                    return "是";
                }
            }
        },
        {
            targets: -2,
            render: function (data, type, row, meta) {
                if (row.test_id == null || row.test_id == "") {
                    return "待回访";
                } else {
                    return "已回访";
                }
            }
        },
        {
            targets: -1,
            render: function (data, type, row, meta) {
                if ((row.recycle_id == null || row.recycle_id == "") && row.record_result != 3) {
                    var context = {
                        func: [
                            {
                                "name": "回访",
                                "fn": "ReturnVisit(\'" + row.id + "\',\'" + row.product_name + "\')",
                                "icon": "am-icon-pencil-square-o",
                                "class": "am-text-secondary"
                            }
                        ]
                    };
                } else {
                    var context = {
                        func: [
                            {
                                "name": "查看",
                                "fn": "showTestDetail(\'" + row.id + "\',\'" + row.product_name + "\')",
                                "icon": "am-icon-pencil-square-o",
                                "class": "am-text-secondary"
                            }
                        ]
                    };
                }

                var html = template_btn(context);
                return html;
            }
        }
    ]);
    dto.sScrollXInner = "100%";
    var myTable = $("#dt").DataTable(dto);

    /**
     * 刷新列表
     */
    function refreshPage() {
        $("#pageStatus").val(1);
        myTable.ajax.reload(null, false);
    }

    /**
     * 全选按钮
     */
    function checkAll(obj) {
        $("input[name='item_check_btn']").each(function () {
            $(this).prop("checked", obj.checked);
        });
    }

    function checkItem(obj) {
        var checked = true;
        $("input[name='item_check_btn']").each(function () {
            if (!this.checked) {
                checked = false;
                return false;
            }
        });
        $("#check_all_btn").prop("checked", checked);
    }
    /**
     * 导出数据
     */
    function expDataExcel() {
        var params = "";
        var array = $("#searchForm").serializeArray();
        $.each(array, function () {
            params += "&" + this.name + "=" + this.value;
        });
        var ids = "";
        $("input[name='item_check_btn']").each(function () {
            if (this.checked) {
                ids += this.value + ",";
            }
        });
        window.open("${ctx}/file/download.do?fileId=34&ids=" + ids + params, "导出");
    }
    /**
     * 查看订单详情
     */
    function showTestDetail(id, product) {
        func_reload_page("${ctx}/recycle/recycleTestDetail.do?id=" + id + "&product=" + product);
    }

    function ReturnVisit(id, product) {
        func_reload_page("${ctx}/recycle/recycleTestRecord.do?id=" + id + "&product=" + product);
    }

</script>