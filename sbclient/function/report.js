function draw_datepicker() {
    $.fn.datepicker.dates['vi'] = {
        days: ["Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy", "Chủ Nhật"],
        daysShort: ["CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN"],
        daysMin: ["CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN"],
        months: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
        monthsShort: ["Thg 1", "Thg 2", "Thg 3", "Thg 4", "Thg 5", "Thg 6", "Thg 7", "Thg 8", "Thg 9", "Thg 10", "Thg 11", "Thg 12"],
        today: "Hôm Nay"
    };

    var seff = $(".selectDate").datepicker({
        isRTL: false,
        format: 'yyyy-mm-dd',
        autoclose: true,
        language: 'vi'
    });

}
draw_datepicker();

function report() {
    var table = $('.listBooking tbody');
    var date1 = $('#date1').val();
    var date2 = $('#date2').val();
    if (!date1 || !date2) {
        alert('Nhập đầy đủ thông tin!');
        return false;
    }
    $.ajax({
        contentType: "application/json",
        dataType: "json",
        type: "post",
        url: "http://localhost:9999/api/booking/check",
        data: JSON.stringify({
            date1: date1,
            date2: date2
        }),
        headers: {
            "Authorization": "Bearer " + localStorage.getItem('myToken')
        },
        success: function (result) {
            if (typeof (result.dataList) != 'undefined') {
                if (result.dataList.length > 0) {
                    $('#dateReport').text(date1 + ' -> ' + date2);
                    $('#booking_result').fadeIn();
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