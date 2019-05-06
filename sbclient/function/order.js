function loadData() {
    var userId = localStorage.getItem('userId');
    var roleId = localStorage.getItem('roleId');
    var table = $('.listBooking tbody');
    if(roleId != 1){
        $.ajax({
            contentType: "application/json",
            dataType: "json",
            type: "post",
            url: "http://localhost:9999/api/booking/"+userId,
            data: JSON.stringify({
                userId: userId
            }),
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            success: function (result) {
                if (typeof (result.dataList) != 'undefined') {
                    if (result.dataList.length > 0) {
                        table.empty();
                        var html = '';
                        $.each(result.dataList, function (i, item) {
                            html += '<tr><td>' + item[0] + '</td><td>' + item[2] + ' ' + item[3] + '</td><td>' + item[4] + '</td><td>' + item[1] + '</td><td><a onclick="getDetail(' + item[0] + ')" class="btn btn-info">Xem chi tiết</a></td></tr>';
                        });
                        table.append(html);
                        $('.listBooking').dataTable();
                    } else {
                        alert('Không có dữ liệu');
                    }
                }
            },
            error: function (error) {
                alert('Lỗi ko get đc sân');
            }
        });
    }else{
        $.ajax({
            dataType: "json",
            type: "get",
            url: "http://localhost:9999/api/booking",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('myToken')
            },
            success: function (result) {
                if (typeof (result.dataList) != 'undefined') {
                    if (result.dataList.length > 0) {
                        table.empty();
                        var html = '';
                        $.each(result.dataList, function (i, item) {
                            html += '<tr><td>' + item[0] + '</td><td>' + item[2] + ' ' + item[3] + '</td><td>' + item[4] + '</td><td>' + item[1] + '</td><td><a onclick="getDetail(' + item[0] + ')" class="btn btn-info">Xem chi tiết</a></td></tr>';
                        });
                        table.append(html);
                        $('.listBooking').dataTable();
                    } else {
                        alert('Không có dữ liệu');
                    }
                }
            },
            error: function (error) {
                alert('Lỗi ko get đc sân');
            }
        });
    }
}

loadData();

function getDetail(id) {
    var table = $('.listBookingDetail tbody');
    $.ajax({
        contentType: "application/json",
        dataType: "json",
        type: "post",
        url: "http://localhost:9999/api/bookingdetail/report",
        data: JSON.stringify({
            booking_id: id
        }),
        headers: {
            "Authorization": "Bearer " + localStorage.getItem('myToken')
        },
        success: function (result) {
            if (typeof (result.dataList) != 'undefined') {
                if (result.dataList.length > 0) {
                    $('#bookingId').text(id);
                    $('#bookingDetail').modal();
                    table.empty();
                    var html = '';
                    var price = 0;
                    $.each(result.dataList, function (i, item) {
                        price += item[4];
                        var tt = 'Chưa duyệt';
                        if(item[5] == 1){
                            tt = 'Đã duyệt';
                        }
                        html += '<tr><td>' + item[0] + '</td><td>' + item[1]+'</td><td>' + item[3]+'</td><td>' + item[2] + '</td><td>' + item[4] + '</td><td>' + tt + '</td></tr>';
                    });
                    table.append(html);
                    $('.listBookingDetail').dataTable();
                    $('#price').text('Tổng giá: '+price+ ' VNĐ');
                } else {
                    alert('Không có dữ liệu');
                }
            }
        },
        error: function (error) {
            alert('Lỗi ko get đc sân');
        }
    });
}