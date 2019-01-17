function hexToRGB2(str) {
  var strPrePre = str.substring(1, str.length);
  var result = [];
  if (strPrePre.length == 6) {
    for (var i = 0; i < strPrePre.length; i += 2) {
      var ele = strPrePre[i] + strPrePre[i + 1];
      //console.log(ele);
      var ele = parseInt(ele, 16);
      result.push(ele);
    }
  } else {
    for (var i = 0; i < strPrePre.length; i++) {
      var ele = strPrePre[i] + strPrePre[i];
      //console.log(ele);
      var ele = parseInt(ele, 16);
      result.push(ele);
    }
  }
  return result.toString();
}
