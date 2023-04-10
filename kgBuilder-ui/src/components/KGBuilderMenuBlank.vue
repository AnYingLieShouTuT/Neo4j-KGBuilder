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
    <li class="el-dropdown-menu__item" @click="btnAddRule">
      <span class="pl-15">添加规则</span>
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
    };
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
    btnAddRule() {
      this.$emit("addRule");
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
<style></style>
