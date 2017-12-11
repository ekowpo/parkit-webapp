$(document).ready(function () {
    document.getElementById("username").innerHTML = localStorage.getItem("name");

});

    
    function loadParkinglots() {
        var url = "api/parkinglot";

        if (!$.fn.dataTable.isDataTable('#parkinglots')) {
            var table = $('#parkinglots')
                .DataTable(
                {
                    "order": [[1, "asc"]],
                    "searching": false,
                    "paging": false,
                    ajax: {
                        url: url,
                        type: 'GET',
                        draw: 1,
                        data: {
                            location: function () { return document.getElementById("pac-input").value; }
                        }
                    },
                    columns: [
                        {
                            data: 'name'
                        },
                        {
                            data: 'distance'
                        },
                        {
                            data: 'mins'
                        },
                        {
                            data: function (aData) {
                                return '<a href="parkinglot.html?name=' + aData.name + '">View Price</a>';
                            }
                        }
                    ],
                    fnRowCallback: function (
                        nRow, aData,
                        iDisplayIndex,
                        iDisplayIndexFull) {

                        return nRow;
                    }
                });
        }
        else {
            $('#parkinglots')
                .DataTable().ajax.reload();
        }
    }


