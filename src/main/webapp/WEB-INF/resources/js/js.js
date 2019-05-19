function test() {
    alert("Javascript is working!");
}

function register() {
    alert("Welcome to here");
}

function login(){
    alert("login!");
}
$(".reveal").on('click',function() {
    var $pwd = $(".pwd");
    if ($pwd.attr('type') === 'password') {
        $pwd.attr('type', 'text');
    } else {
        $pwd.attr('type', 'password');
    }
});

