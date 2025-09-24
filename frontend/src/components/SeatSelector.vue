<script setup>
import { ref, onMounted } from 'vue'
import { getAllSeats, assignSeat } from '../services/seatService'
import { getAllEmployees } from '../services/employeeService'

// 員工清單
const employees = ref([])

const selectedEmp = ref('')
const seats = ref([])
const selectedSeat = ref(null)

onMounted(async () => {
  const res = await getAllEmployees()
  employees.value = res.data
  await loadSeats()
})

const loadSeats = async () => {
  try {
    const res = await getAllSeats()
    seats.value = res.data
  } catch (err) {
    console.error('載入座位失敗:', err)
  }
}

function seatClass(seat) {
  if (selectedSeat.value?.floorSeatSeq === seat.floorSeatSeq) {
    return 'selected-seat'
  }
  return seat.isTaken ? 'taken-seat' : 'empty-seat'
}

function chooseSeat(seat) {
  if (seat.isTaken) {
    alert('這個座位已被佔用！')
    return
  }
  selectedSeat.value = seat
}

async function submitSeat() {
  if (!selectedEmp.value || !selectedSeat.value) {
    alert('請先選擇員工與座位！')
    return
  }
  try {
    await assignSeat(selectedEmp.value, selectedSeat.value.floorSeatSeq)
    alert('座位分配成功！')
    selectedSeat.value = null
    await loadSeats()
    const empRes = await getAllEmployees()
    employees.value = empRes.data
  } catch (err) {
    console.error('分配失敗:', err)
    alert('分配失敗，請檢查後端或資料庫')
  }
}
</script>

<template>
  <div class="seat-selector">
    <h2>座位選擇系統</h2>

    <!-- 員工下拉選單 -->
    <label for="employee">選擇員工：</label>
    <select id="employee" v-model="selectedEmp">
      <option disabled value="">請選擇員工</option>
      <option v-for="emp in employees" :key="emp.empId" :value="emp.empId">
        {{ emp.name }} (ID: {{ emp.empId }} 姓名:{{emp.empName}})
      </option>
    </select>

<!-- 座位格子 -->
<div class="seat-grid">
  <button
    v-for="seat in seats"
    :key="seat.floorSeatSeq"
    :class="seatClass(seat)"
    @click="chooseSeat(seat)"
  >
    {{ seat.seatNo }}
    <span v-if="seat.isTaken">
      (員工編號: {{ employees.find(e => e.floorSeatSeq === seat.floorSeatSeq)?.empId }})
    </span>
  </button>
</div>

    <!-- 送出按鈕 -->
    <button class="submit-btn" @click="submitSeat">送出</button>
  </div>

  <!-- 圖例區塊 -->
  <div class="legend">
  <div><span class="legend-box empty"></span> 空位</div>
  <div><span class="legend-box taken"></span> 已佔用</div>
  <div><span class="legend-box selected"></span> 已選中</div>
  </div>
</template>

<style scoped>
.seat-selector {
  max-width: 600px;
  margin: 0 auto;
  text-align: center;
}
.seat-grid {
  display: grid;
  grid-template-columns: repeat(4, 100px); /* 一列 4 個 */
  gap: 10px;
  margin: 20px auto;
  justify-content: center;
}
.empty-seat {
  background-color: lightgray;
}
.taken-seat {
  background-color: red;
  color: white;
}
.selected-seat {
  background-color: lightgreen;
}
button {
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
}
.submit-btn {
  margin-top: 20px;
  background-color: dodgerblue;
  color: white;
}
.legend {
  position: fixed;
  bottom: 10px;
  left: 10px;
  font-size: 14px;
}
.legend-box {
  display: inline-block;
  width: 20px;
  height: 20px;
  margin-right: 5px;
  border: 1px solid black;
}
.legend-box.empty {
  background-color: white;
}
.legend-box.taken {
  background-color: red;
}
.legend-box.selected {
  background-color: lightgreen;
}
</style>