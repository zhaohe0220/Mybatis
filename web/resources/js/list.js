/**
 * Created by yunfei on 2017/2/14.
 */
function deleteBatch(basePath) {
    $("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
    $("#mainForm").submit();
}

function changeCurrentPage(currentPage) {
    $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}