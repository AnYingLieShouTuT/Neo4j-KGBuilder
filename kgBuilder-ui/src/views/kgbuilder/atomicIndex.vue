<template>
  <div>
    <el-row type="flex" class="row-bg" justify="center">
      <el-col :span="20">
        <h1 class="title">
          原子指标
          <el-button
            size="medium"
            @click="addAtomicIndex()"
            type="primary"
            style="margin-left: 20px"
            >添加</el-button
          >
        </h1>
      </el-col>
    </el-row>
    <el-row type="flex" class="row-bg" justify="center">
      <el-col :span="20"
        ><div class="grid-content">
          <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            :header-cell-style="{ textAlign: 'center' }"
          >
            <el-table-column prop="id" label="id" width="50" align="center">
            </el-table-column>
            <el-table-column prop="" label="指标内容" align="center" width="200">
              <template slot-scope="scope">
                <!-- <p>{{'总人数'}} {{ (Number(scope.row.count1)) + (Number(scope.row.count2))}}</p> -->
                <p v-if="scope.row.indexSymbol != null">
                  {{
                    scope.row.indexJudgeMethod +
                    scope.row.indexSymbol +
                    scope.row.indexValue
                  }}
                </p>
                <p v-if="scope.row.indexSymbol == null">
                  {{
                    $stringFormat(
                      scope.row.indexJudgeMethod.toString(),
                      scope.row.indexValue.split(",")
                    )
                  }}
                </p>
              </template>
            </el-table-column>
            <el-table-column prop="indexJudgeMethod" label="指标" width="" align="center">
            </el-table-column>
            <el-table-column prop="indexSymbol" label="符号" width="50" align="center">
            </el-table-column>
            <el-table-column prop="indexValue" label="数值" width="60" align="center">
            </el-table-column>
            <el-table-column prop="dataType" label="数据类型" width="120" align="center">
            </el-table-column>
            <el-table-column prop="description" label="指标描述" width="">
              <template slot-scope="scope">
                <p v-if="scope.row.description != null || scope.row.description != ''">
                  {{
                    scope.row.description.length > 5
                      ? scope.row.description.slice(0, 65) + "..."
                      : scope.row.description
                  }}
                  <i
                    class="el-icon-copy-document icon"
                    @click="showDialog(scope.row)"
                    v-show="scope.row.description != null || scope.row.description != ''"
                  ></i>
                  <el-dialog :visible.sync="dialogVisible" width="30%">
                    <span slot="title">
                      <i class="el-icon-edit"></i>
                      <span>指标描述</span>
                    </span>
                    {{ data }}
                  </el-dialog>
                </p>
              </template>
            </el-table-column>

            <el-table-column
              prop="associateTableName"
              label="关联表"
              width="100"
              align="center"
            >
            </el-table-column>
            <el-table-column label="操作" align="center" width="170">
              <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
                  >编辑</el-button
                >
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
                  >删除</el-button
                >
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
          </div></div
      ></el-col>
    </el-row>
  </div>
</template>
<script>
import {kgBuilderApi} from "@/api";

export default {
  name: "rules",
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
  mounted() {},
  created() {
    this.getRules();
  },
  methods: {
    getRules() {
      let that = this;
      let data = { pageCode: this.params.page, pageSize: this.params.size };
      kgBuilderApi.getAtomicIndexPage(data).then((result) => {
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
