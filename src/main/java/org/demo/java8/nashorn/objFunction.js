/**
 * Created by belong on 2017/3/28.
 */
function myFunction(arg1, arg2) {
    this.firstName = arg1;
    this.lastName = arg2;
}
x = new myFunction("John","Doe");
x.firstName;
print(x.firstName);
print(x.lastName)
print(typeof x);
