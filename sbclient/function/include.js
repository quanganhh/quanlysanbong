function loadHTML() {
    var path = window.location.search;
    var file = path.split('=');
    if (typeof file[1] != 'undefined') {
        var view = file[1].replace('-', '/');
        $('#body-data').load(view + '.html');
    } else {
        $('#body-data').load('dashboard.html');
    }

    var roleId = localStorage.getItem('roleId');
    if(roleId == 2){
        $('#account, #pitch, #time').remove();
}
}

function path(str){
    window.location.href = 'index.html?view='+str;
}