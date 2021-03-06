<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>
<link rel="stylesheet" href="${webResourceUrl}/resource/order/css/order.detail.css">
<link rel="stylesheet" href="${webResourceUrl}/resource/layui/css/modules/laydate/default/laydate.css">
<link rel="stylesheet" href="${webResourceUrl}/resource/layui/css/modules/layer/default/layer.css">
<link rel="stylesheet" href="${webResourceUrl}/resource/layui/css/modules/code.css">
<link rel="stylesheet" href="${webResourceUrl}/resource/zoom/css/zoom.css">
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf" style="width: 100%;">
        <strong class="am-text-primary am-text-lg"><a href="javascript:void(0);" onclick="toList();">商机订单管理</a></strong>
        /
        <small>订单详情</small>
        <strong class="am-text-primary"><a href="javascript:void(0);" onclick="func_to_back();">返回</a></strong>
    </div>
</div>

<hr>

<div class="am-g">
    <div class="panel panel-success index-panel-msg">
        <h4>
            订单状态：
            <c:if test="${sjOrder.state==100}">
                待审核
            </c:if>
            <c:if test="${sjOrder.state==200}">
                待反馈
            </c:if>
            <c:if test="${sjOrder.state==300}">
                已转化
            </c:if>
            <c:if test="${sjOrder.state==400}">
                已完结
            </c:if>
            <c:if test="${sjOrder.state==600}">
                未通过
            </c:if>
        </h4>
    </div><!-- /panel -->
</div>
<!-- /am-g -->

<div class="am-g order-info mt20">
    <table class="detail-table">
        <tr>
            <td class="td-title">
                <h4>订单信息：</h4>
            </td>
            <td class="td-space"></td>
            <td class="td-info">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <h4>订单号：${sjOrder.orderNo }</h4>
                    </div><!-- /.col -->
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <c:if test="${sjOrder.type==1}">
                            <h4>订单类型：商机单</h4>
                        </c:if>
                        <c:if test="${sjOrder.type==2}">
                            <h4>订单类型：派单</h4>
                        </c:if>
                    </div><!-- /.col -->

                </div><!-- /.row -->

                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <h4>创建时间：<fmt:formatDate value="${sjOrder.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
                    </div><!-- /.col -->
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <h4>单位名字：${sjOrder.companyName }</h4>
                    </div><!-- /.col -->
                </div><!-- /.row -->

                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <h4>联系人/电话：${sjOrder.person }/${sjOrder.phone }</h4>
                    </div><!-- /.col -->

                </div><!-- /.row -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <h4>地址：${sjOrder.address} ${sjOrder.addressDetail}</h4>
                    </div><!-- /.col -->
                </div><!-- /.row -->

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <h4>产品需求：${sjOrder.projectNames }</h4>
                    </div><!-- /.col -->
                </div><!-- /.row -->

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <h4>
                            <c:if test="${sjOrder.type==1}">
                                <h4>门头图片：</h4>
                            </c:if>
                            <c:if test="${sjOrder.type==2}">
                                <h4>受理单或合同图片：</h4>
                            </c:if>
                            <c:forEach items="${companyPictures }" var="item" varStatus="i">
                                <img src="${item.companyPictureUrl}" class="layui-upload-img"
                                     onclick="zoomImage('${item.companyPictureUrl}')"
                                     width="90" height="80"
                                     style="cursor:pointer"/>
                            </c:forEach>
                        </h4>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </td>
        </tr>
        <c:if test="${sjOrder.state==100}">
            <tr>
                <td colspan="3" class="tr-space"></td>
            </tr>
            <tr>
                <td class="td-title">
                    <h4>审批信息：</h4>
                </td>
                <td class="td-space"></td>
                <td class="td-info">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <textarea name="note" id="note" cols="79" rows="5" placeholder="请输入审批备注"></textarea>
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                    <div class="index_but">
                        <button onclick="orderCancel('${sjOrder.id}','2');" class="am-btn am-btn-default search_btn"
                                type="button"> 不同意
                        </button>
                        <button onclick="orderCancel('${sjOrder.id}','1');" class="am-btn am-btn-default search_btn"
                                type="button"> 同意
                        </button>
                    </div>

                </td>
            </tr>
        </c:if>
        <c:if test="${sjOrder.state==200||sjOrder.state==300||sjOrder.state==400||sjOrder.state==600}">
            <tr>
                <td colspan="3" class="tr-space"></td>
            </tr>
            <tr>
                <td class="td-title">
                    <h4>审批信息：</h4>
                </td>
                <td class="td-space"></td>
                <td class="td-info">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h4>备注：${sjOrder.approvalNote }</h4>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <h4>审批人：${sjOrder.approvalPerson }</h4>
                        </div><!-- /.col -->
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <h4>审批时间：<fmt:formatDate value="${sjOrder.approvalTime }"
                                                     pattern="yyyy-MM-dd HH:mm:ss"/></h4>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </td>
            </tr>
        </c:if>
        <c:if test="${loginUserType==6 || loginUserType==1}">
            <c:if test="${sjOrder.state==200}">
                <tr>
                    <td colspan="3" class="tr-space"></td>
                </tr>
                <tr>
                    <td class="td-title">
                        <h4>反馈信息：</h4>
                    </td>
                    <td class="td-space"></td>
                    <td class="td-info">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <textarea name="feedNote" id="feedNote" cols="79" rows="5"
                                          placeholder="请输入反馈备注"></textarea>
                            </div><!-- /.col -->
                        </div><!-- /.row -->

                        <div class="index_but">
                            <button onclick="orderFeedBack('${sjOrder.id}','1');"
                                    class="am-btn am-btn-default search_btn" type="button"> 转化
                            </button>
                            <button onclick="orderFeedBack('${sjOrder.id}','2');"
                                    class="am-btn am-btn-default search_btn" type="button"> 完结
                            </button>
                        </div>
                    </td>
                </tr>
            </c:if>
        </c:if>
        <c:if test="${sjOrder.state==300||sjOrder.state==400}">
            <tr>
                <td colspan="3" class="tr-space"></td>
            </tr>
            <tr>
                <td class="td-title">
                    <h4>反馈信息：</h4>
                </td>
                <td class="td-space"></td>
                <td class="td-info">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h4>反馈备注：${sjOrder.feedbackNote }</h4>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <h4>反馈人：${sjOrder.feedbackPerson }</h4>
                        </div><!-- /.col -->
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <h4>反馈时间：<fmt:formatDate value="${sjOrder.feedbackTime }"
                                                     pattern="yyyy-MM-dd HH:mm:ss"/></h4>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </td>
            </tr>
        </c:if>

    </table>
</div>
<!-- /am-g -->
<script src="${webResourceUrl}/resource/zoom/js/zoom.js" type="text/javascript" charset="utf-8"></script>
<%--<script src="${webResourceUrl}/plugins/assets/js/" type="text/javascript" charset="utf-8"></script>--%>
<script src="${webResourceUrl}/resource/layui/layui.all.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    function toList() {
        func_reload_page("${ctx}/sj/order/list.do");
    }
    $(function() {
        /*
         smallimg   // 小图
         bigimg  //点击放大的图片
         mask   //黑色遮罩
         */
        var obj = new zoom('mask', 'bigimg', 'smallimg');
        obj.init();
    })

    function toBigImg(obj) {
//        alert(parseInt(obj.style.zoom,10));
        var zoom = parseInt(obj.style.zoom, 10) || 100;
        zoom += event.wheelDelta / 12;
        if (zoom > 0) {
            obj.style.zoom = zoom + '%';
        }
        return false;
    }

    function zoomImage(url) {
        var imgHtml = "<img src='" + url + "' width='auto' height='500' onmousewheel='return toBigImg(this)' style='cursor:pointer'/>";
        //弹出层
        layer.open({
            type: 1,
            shade: 0.8,
            offset: 'auto',
            area: ['auto', 'auto'],
            shadeClose: true,
            scrollbar: false,
            title: "图片预览", //不显示标题
            content: imgHtml //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
//            cancel: function () {
//                layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
//            }
        });
    }

    function orderCancel(id, isPast) {
        var note = $("#note").val();
        if (note == null || note == "") {
            AlertText.tips("d_alert", "提示", "请输入备注");
        }
        var url_ = AppConfig.ctx + "/sj/order/approval.do";
        $.ajax({
            url: url_,
            type: "POST",
            data: {id: id, isPast: isPast, note: note},
            dataType: "json",
            success: function (result) {
                if (result.success) {
                    func_reload_page("${ctx}/sj/order/detail.do?id=" + id);
                } else {
                    AlertText.tips("d_alert", "提示", result.resultMessage);
                }
            },
            error: function () {
                AlertText.tips("d_alert", "提示", "系统异常，请稍后再试");
            }
        });
    }

    function orderFeedBack(id, isPast) {
        var feedNote = $("#feedNote").val();
        if (feedNote == null || feedNote == "") {
            AlertText.tips("d_alert", "提示", "请输入备注");
        }
        var url_ = AppConfig.ctx + "/sj/order/feedback.do";
        $.ajax({
            url: url_,
            type: "POST",
            data: {id: id, isPast: isPast, feedNote: feedNote},
            dataType: "json",
            success: function (result) {
                if (result.success) {
                    func_reload_page("${ctx}/sj/order/detail.do?id=" + id);
                } else {
                    AlertText.tips("d_alert", "提示", result.resultMessage);
                }
            },
            error: function () {
                AlertText.tips("d_alert", "提示", "系统异常，请稍后再试");
            }
        });
    }
</script>
