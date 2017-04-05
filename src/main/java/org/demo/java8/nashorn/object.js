/**
 * Created by belong on 2017/3/28.
 */
function person(firstname,lastname,age,eyecolor)
{
    this.firstname=firstname;
    this.lastname=lastname;
    this.age=age;
    this.eyecolor=eyecolor;
}
print(typeof person)
var p = new person("belong","mr",23,"red");
print(typeof p);
print(p.firstname)
print(typeof p.firstname);

function person2(firstname,lastname,age,eyecolor)
{
    this.firstname=firstname;
    this.lastname=lastname;
    this.age=age;
    this.eyecolor=eyecolor;

    this.changeName=changeName;
    function changeName(name)
    {
        this.lastname=name;
    }
}
print(typeof person2);
var p2 = new person2("belong","mrfds",23,"red");
p2.changeName("dpc");
print(p2.lastname)
print(typeof p2)
