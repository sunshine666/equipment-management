<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
<title>EBҳ�浼��ΪEXCEL�ĵ��ķ���</title> 
<script type="text/javascript"> 
<!-- download
function saveCode(obj) { 
          var winname = window.open('', '_blank', 'top=10000'); 
          var strHTML = document.all.tableExcel.innerHTML; 
          winname.document.open('text/html', 'replace'); 
          winname.document.writeln(strHTML); 
          winname.document.execCommand('saveas','','excel.xls'); 
          winname.close(); 
} 
--> 
</script> 
</head> 

<body> 
<div id="tableExcel">  
<table id="test" width="100%" border="1" cellspacing="0" cellpadding="0"> 
      <tr> 
          <td colspan="5" align="center">WEBҳ�浼��ΪEXCEL�ĵ��ķ���</td> 
      </tr> 
      <tr> 
          <td>�б���1</td> 
          <td>�б���2</td> 
          <td>�б���3</td> 
          <td>�б���4</td> 
          <td>�б���5</td> 
      </tr> 
      <tr> 
          <td>aaa</td> 
          <td>bbb</td> 
          <td>ccc</td> 
          <td>ddd</td> 
          <td>eee</td> 
      </tr> 
      <tr> 
          <td>AAA</td> 
          <td>BBB</td> 
          <td>CCC</td> 
          <td>DDD</td> 
          <td>EEE</td> 
      </tr> 
      <tr> 
          <td>FFF</td> 
          <td>GGG</td> 
          <td>HHH</td> 
          <td>III</td> 
          <td>JJJ</td> 
      </tr> 
      <tr> 
        <td>aaa</td> 
        <td>bbb</td> 
        <td>ccc</td> 
        <td>ddd</td> 
        <td>eee</td> 
      </tr> 
      <tr> 
        <td>AAA</td> 
        <td>BBB</td> 
        <td>CCC</td> 
        <td>DDD</td> 
        <td>EEE</td> 
      </tr> 
      <tr> 
        <td colspan="5">FFFGGGHHHIIIJJJ</td> 
      </tr> 
     
      <tr> 
        <td>aaa</td> 
        <td>bbb</td> 
        <td>ccc</td> 
        <td>ddd</td> 
        <td>eee</td> 
      </tr> 
      <tr> 
        <td>AAA</td> 
        <td>BBB</td> 
        <td rowspan="4">CCCHHHcccccc</td> 
        <td>DDD</td> 
        <td>EEE</td> 
      </tr> 
      <tr> 
        <td>FFF</td> 
        <td>GGG</td> 
        <td>III</td> 
        <td>JJJ</td> 
      </tr> 
     
      <tr> 
        <td>aaa</td> 
        <td>bbb</td> 
        <td>ddd</td> 
        <td>eee</td> 
      </tr> 
      <tr> 
        <td>aaa</td> 
        <td>bbb</td> 
        <td>ddd</td> 
        <td>eee</td> 
      </tr> 
      <tr> 
        <td>AAA</td> 
        <td>BBB</td> 
        <td>CCC</td> 
        <td>DDD</td> 
        <td>EEE</td> 
      </tr> 
      <tr> 
        <td>FFF</td> 
        <td>GGG</td> 
        <td>HHH</td> 
        <td>III</td> 
        <td>JJJ</td> 
      </tr> 
</table> 
</div> 
<input type="button" value="���Ϊ Excel" onclick="saveCode(tableExcel)"> 
</body> 
</html>