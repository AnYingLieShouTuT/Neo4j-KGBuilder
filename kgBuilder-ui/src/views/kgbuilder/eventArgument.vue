<template>
  <div>
    <el-row type="flex" class="row-bg" justify="center">
      <el-col :span="20">
        <h1 class="title">
          事件论元
          <el-button
            size="medium"
            @click="addEventArgument()"
            type="primary"
            style="margin-left: 20px"
          >添加
          </el-button>
        </h1>
      </el-col>
    </el-row>
    <el-row type="flex" class="row-bg" justify="center">
      <el-col :span="20">
        <div class="grid-content">
          <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column prop="id" label="id" width="50" align="center">
            </el-table-column>
            <el-table-column prop="argumentName" label="论元名称" align="center" width="">
            </el-table-column>
            <el-table-column
              prop="argumentSource"
              label="论元来源"
              width=""
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="associateTablesName"
              label="关联表"
              width=""
              align="center"
            >
            </el-table-column>
            <el-table-column label="操作" align="center" width="170">
              <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
                >编辑
                </el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
                >删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <!--   element-ui分页组件-->
          <div class="block">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="this.params.page"
              :page-sizes="[5, 10, 50, 100]"
              :page-size="this.params.size"
              layout="total, sizes, prev, pager, next, jumper"
              :total="this.total"
            >
            </el-pagination>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import {kgBuilderApi} from "@/api";

export default {
  name: "eventArgument",
  data() {
    return {
      tableData: [], //表格显示的数据
      page: 1,
      size: 0,
      total: 0,
      params: {
        page: 1,
        size: 10,
      },
      dialogVisible: false,
      data: null,
    };
  },
  components: {},
  mounted() {
  },
  created() {
    this.getEventArgument();
  },
  methods: {
    getEventArgument() {
      let that = this;
      let data = {pageCode: this.params.page, pageSize: this.params.size};
      kgBuilderApi.getEventArgumentPage(data).then((result) => {
        if (result.code == 200) {
          that.tableData = result.data.records;
          that.total = result.data.total;
        }
      });
    },
    showDialog(row) {
      this.dialogVisible = true;
      this.data = row.description;
    },

    //    分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.params.size = val;
      this.getRules();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.params.page = val;
      this.getRules();
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    filterLevel(value, row) {
      return row.level === value;
    },
  },
};
</script>
<style>
.title {
  float: left;
  width: 260px;
  font-size: 26px;
  height: 50px;
  line-height: 50px;
  vertical-align: middle;
  display: flex;
  align-items: center;
}
</style>
