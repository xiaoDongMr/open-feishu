import request from '@/utils/request'

// 查询饿了么门店数据列表
export function listElmData(query) {
  return request({
    url: '/platform/elmData/list',
    method: 'get',
    params: query
  })
}

// 查询饿了么门店数据详细
export function getElmData(id) {
  return request({
    url: '/platform/elmData/' + id,
    method: 'get'
  })
}

// 新增饿了么门店数据
export function addElmData(data) {
  return request({
    url: '/platform/elmData',
    method: 'post',
    data: data
  })
}

// 修改饿了么门店数据
export function updateElmData(data) {
  return request({
    url: '/platform/elmData',
    method: 'put',
    data: data
  })
}

// 删除饿了么门店数据
export function delElmData(id) {
  return request({
    url: '/platform/elmData/' + id,
    method: 'delete'
  })
}
