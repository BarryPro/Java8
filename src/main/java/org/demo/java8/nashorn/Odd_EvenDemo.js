/**
 * Created by belong on 2017/3/27.
 */
var data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
// 过滤掉奇数
var filtered1 = data.filter(function(i) {
    return i % 2 == 0;
});
var filtered2 = data.filter(function(i) {
    return i % 2 != 0;
});
print("Even:"+filtered1);
print("Odd:"+filtered2);

var sumOfFiltered = filtered1.reduce(function(acc, next) {
    return acc + next;
}, 0);
print(sumOfFiltered);
