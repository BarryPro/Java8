/**
 * Created by belong on 2017/3/28.
 */
var person={fname:"John",lname:"Doe",age:25};
var txt
for (x in person)
{
    txt += person[x];
}
print(typeof person)
print(txt)
