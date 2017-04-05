/**
 * Created by belong on 2017/3/28.
 */
myArray = new Array();
myDate = new Date();


fun = function isArray(myArray) {
    return myArray.constructor.toString().indexOf("Array") > -1;
}
function isDate(myDate) {
    return myDate.constructor.toString().indexOf("Date") > -1;
}
fun.constructor;
fun
isDate();

