define(function (require, exports, module) {
    exports.init = function () {
        console.log("demo1 inited");
    };
    console.log(module);
//    module.exports = {
//        a: 1,
//        b: 2,
//        init: function () {
//            console.log("demo1 inited");
//        }
//    }
//    return {
//        a:1,
//        b:2
//    }
});