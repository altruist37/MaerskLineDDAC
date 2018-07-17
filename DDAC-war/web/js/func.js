/**
 * Created by abspk on 27/05/2017.
 */

$(document).ready(function () {
    $(function () {
        //jQuery('#datetimepicker').datetimepicker();
        $('#datetimepicker').datetimepicker();
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker2').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker3').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker4').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker5').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker6').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker7').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

$(document).ready(function () {
    $(function () {
        $('#datetimepicker8').datetimepicker({
            lang:'en',
            timepicker:false,
            format:'d/m/Y',
            formatDate:'Y/m/d',
            minDate:'-1970/01/01' // today is the minimum date
            //maxDate:'+1970/01/02' // maximum goes till the month end
        });
    });
});

function redirection(url) {
    var seconds = 5;
    var interval = setInterval(function() {
        document.getElementById('count').innerHTML = --seconds;
        
        if(seconds <= 0) {
            window.location.replace(url);
            clearInterval(interval);
        }
    }, 1000);
}