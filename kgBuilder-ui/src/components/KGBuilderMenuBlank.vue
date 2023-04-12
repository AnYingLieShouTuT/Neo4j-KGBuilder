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
    <li class="el-dropdown-menu__item" @click="dialogFormVisible = true">
      <span class="pl-15">添加规则</span>
    </li>
    <el-dialog title="选择规则" :visible.sync="dialogFormVisible" :append-to-body="true">
      <el-form :model="form">
        <el-form-item label="规则" :label-width="formLabelWidth">
          <el-select
            v-model="form"
            placeholder="请选择规则"
            class="my-select"
            filterable
            required
          >
            <el-option
              v-for="rule in rules"
              :key="rule.id"
              :value="rule"
              :label="rule.rule"
            >
              <span style="float: left">{{ rule.rule }}</span>
              <span style="float: right; color: #8492a6; font-size: 13px">{{
                  rule.level
                }}</span>
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" plain @click="btnAddRule">确 定</el-button>
      </div>
    </el-dialog>
    <li class="el-dropdown-menu__item" @click="btnQuickAddNode">
      <span class="pl-15">快速添加</span>
    </li>
  </ul>
</template>

<script>
export default {
  props: {
    data: Object,
    rules: {
      type: Array,
      default: () => [],
      required: true,
    },
  },
  data() {
    return {
      top: "0px",
      left: "0px",
      menuBarShow: false,
      formLabelWidth: "120px",
      dialogFormVisible: false,
      form: null,
    };
  },
  mounted() {
    // console.log("MenuBlank")
    // console.log(this.rules);
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
      if (this.form == null || this.form.id == null) {
        this.$message({
          showClose: true,
          message: "请选择规则！",
          type: "warning",
        });
      } else {
        //   console.log(this.form.id);
        this.$emit("addRule", this.form);
        this.form = null;
        this.dialogFormVisible = false;
      }
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
