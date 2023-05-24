<template>
  <!-- 空白处右键 -->
  <ul
    class="el-dropdown-menu el-popper blankmenubar"
    @click="menuBarClick"
    :style="blankMenuStyle"
    @mouseleave="menuBarLeave"
    id="blank_menubar"
    v-show="menuBarShow"
  >
    <li class="el-dropdown-menu__item" @click="btnAddSingle">
      <span class="pl-15">添加节点</span>
    </li>
    <li class="el-dropdown-menu__item" @click="btnQuickAddNode">
      <span class="pl-15">快速添加</span>
    </li>
    <li class="el-dropdown-menu__item" @click="btnAddEvent">
      <span class="pl-15">添加事件</span>
    </li>
  </ul>
</template>

<script>
export default {
  props: {
    data: Object,
  },
  data() {
    return {
      top: "0px",
      left: "0px",
      menuBarShow: false,
      formLabelWidth: "120px",
      form: null,
    };
  },
  mounted() {
  },
  inject: ["quickAddNodes"],
  components: {},
  computed: {
    blankMenuStyle() {
      return {
        position: "absolute",
        top: this.top + "px",
        left: this.left + "px",
      };
    },
  },
  methods: {
    init(data) {
      this.top = data.top;
      this.left = data.left;
      this.menuBarShow = data.show;
    },
    btnAddEvent() {
      this.$prompt("", "请输入事件抽取结果", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputType: "textarea",
        closeOnClickModal: false,
      })
        .then(({value}) => {
          //   console.log(value);
          this.$emit("addEventNode", value);
        })
        .catch(() => {
        });
    },
    btnAddSingle() {
      this.$emit("changeCursor");
    },
    btnQuickAddNode() {
      this.quickAddNodes(this);
    },
    menuBarClick() {
      this.menuBarShow = false;
    },
    menuBarLeave() {
      this.menuBarShow = false;
    },
  },
};
</script>
<style>
.my-select {
  width: 100%;
}

.my-select .el-input {
  width: 90%;
}
</style>
