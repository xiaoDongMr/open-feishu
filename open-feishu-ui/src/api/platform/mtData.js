import request from '@/utils/request'

// 查询美团门店数据列表
export function listMtData(query) {
  return request({
    url: '/platform/mtData/list',
    method: 'get',
    params: query
  })
}

// 查询美团门店数据详细
export function getMtData(id) {
  return request({
    url: '/platform/mtData/' + id,
    method: 'get'
  })
}

// 新增美团门店数据
export function addMtData(data) {
  return request({
    url: '/platform/mtData',
    method: 'post',
    data: data
  })
}

// 修改美团门店数据
export function updateMtData(data) {
  return request({
    url: '/platform/mtData',
    method: 'put',
    data: data
  })
}

// 删除美团门店数据
export function delMtData(id) {
  return request({
    url: '/platform/mtData/' + id,
    method: 'delete'
  })
}
