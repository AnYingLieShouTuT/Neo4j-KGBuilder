<template>
  <div id="richContainer" :style="richerStyle" v-show="richerShow">
    <el-scrollbar v-show="editorContent != ''" class="mind-fj-p">
      <p v-html="editorContent"></p>
    </el-scrollbar>
  </div>
</template>

<script>
import E from "wangeditor";
export default {
  props: {
    data: Object,
  },
  data() {
    return {
      richerShow: false,
      left: "-1000px",
      top: "-1000px",
      editor: null,
      editorContent: "",
      showImageList: [],
    };
  },
  computed: {
    richerStyle() {
      return {
        width: "400px",
        position: "absolute",
        top: this.top + "px",
        left: this.left + "px",
      };
    },
  },
  mounted() {},
  components: {},
  methods: {
    init(content, imageList, left, top) {
      this.richerShow = true;
      this.left = left;
      this.top = top;
      this.editorContent = content;
      this.showImageList = imageList;
    },
    close() {
      this.richerShow = false;
    },
  },
};
</script>
<style></style>
