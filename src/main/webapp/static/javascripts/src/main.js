/**
 * Created by nanwei on 14-8-28.
 */
define(function (require, exports, module) {
    $(".nav-item a").hover(
        function (event) {
            changeName(this);
        },
        function (event) {
            changeName(this);

        }
    );
    function changeName(self){
        var $this = $(self),
            oldVal = $this.text();
        $this.text($this.data("name"))
        $this.data("name",oldVal);
    }
});
