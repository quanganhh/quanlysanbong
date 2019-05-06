function loadHTML() {
    var role_id = localStorage.getItem('roleId');
    var path = window.location.search;
    var file = path.split('=');
    if (typeof file[1] != 'undefined') {
        var view = file[1].replace('-', '/');
        var array_url = ['member/list', 'pitch/list', 'time_duration/list','report/view'];
        if(role_id != 1){
            if($.inArray(view, array_url) != -1){
                $('#body-data').load('dashboard.html');
            }else{
                $('#body-data').load(view + '.html');
            }
        }else{
            $('#body-data').load(view + '.html');
        }
    } else {
        $('#body-data').load('dashboard.html');
    }
    
    if(role_id != 1){
        $('#member, #pitch, #time, #report').remove();
    }
}

function path(str){
    window.location.href = 'index.html?view='+str;
}