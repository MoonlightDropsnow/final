<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {

    })
</script>
<form id="albumDetails" enctype="multipart/form-data" method="post">
    <table align="center">
        <tr><td>图片标题：</td><td><input type="text" name="title"></td></tr>
        <tr><td>选择图片：</td><td><input type="file" name="file"/></td></tr>
        <tr><td>描述信息：</td><td><textarea name="description" cols="23" rows="5" placeholder="输入图片的描述信息"></textarea></td></tr>
    </table>
</form>