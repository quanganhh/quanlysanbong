function loadData() {
    var table = $('.listTime tbody');
    $.ajax({
        dataType: "json",
        type: "get",
        url: "http://localhost:9999/api/timedur",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem('myToken')
        },
        success: function (result) {
            if (typeof (result.dataList) != 'undefined') {
                table.empty();
                var html = '';
                $.each(result.dataList, function (i, item) {
                    html += '<tr><td>' + item.id + '</td><td>' + item.name + '</td><td>' + item.price + '</td><td>' + item.description + '</td><td><a onclick="getDataById(' + item.id + ')" class="btn btn-info">Cập nhật</a> <a onclick="del(' + item.id + ')" class="btn btn-danger">Xóa</a></td></tr>';
                });
                table.append(html);
                $('.listPitch').dataTable();
            }
        },
        error: function (error) {
            alert('Lỗi ko get đc sân');
        }
    });
}

function add() {
    var name = $('#name1').val().trim();
    var price = $('#price1').val().trim();
    var desc = $('#desc1').val().trim();
    if (!name || !price || !desc) {
        alert('Nhập đầy đủ thông tin');
        return false;
    } else {
        var data = {
            name: name,
            price: price,
            description: desc
        };
        data = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9999/api/timedur',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: data,
            success: function (result) {
                if (result.isSuccess == true) {
                    alert('Thêm thành công');
                    window.location = 'index.html?view=time_duration-list';
                }
            },
            error: function (error) {
                alert('Lỗi');
            }
        });
    }
}
function del(id) {
    if (confirm('Bạn có chắc chắn muốn xóa sân bóng này?') == true) {
        $.ajax({
            url: 'http://localhost:9999/api/timedur/' + id,
            type: 'DELETE',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            success: function () {
                alert('Xóa thành công');
                window.location = 'index.html?view=time_duration-list';
            },
            error: function (error) {
                alert('Lỗi');
            }
        });
    }
}

function getDataById(id) {
    $.ajax({
        url: 'http://localhost:9999/api/timedur/' + id,
        type: 'GET',
        headers: {
            "Authorization": "Bearer " + localStorage.getItem('myToken')
        },
        success: function (result) {
            if(result.isSuccess == true){
                $('#id').val(result.data.id);
                $('#name').val(result.data.name);
                $('#desc').val(result.data.description);
                $('#price').val(result.data.price);
                $('#update').modal();
            }
        },
        error: function (error) {
            alert('Lỗi');
        }
    });
}
function update() {
    var id = $('#id').val().trim();
    var name = $('#name').val().trim();
    var price = $('#price').val().trim();
    var desc = $('#desc').val().trim();
    if (!name || !price || !desc) {
        alert('Nhập đầy đủ thông tin');
        return false;
    } else {
        var data = {
            id: id,
            name: name,
            price: price,
            description: desc
        };
        data = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9999/api/timedur',
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: data,
            success: function (result) {
                if (result.isSuccess == true) {
                    alert('Cập nhật thành công');
                    window.location = 'index.html?view=time_duration-list';
                }
            },
            error: function (error) {
                alert('Lỗi');
            }
        });
    }
}
