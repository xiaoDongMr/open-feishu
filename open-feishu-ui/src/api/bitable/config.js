import request from '@/utils/request'

// 查询多维格应用配置列表
export function listConfig(query) {
  return request({
    url: '/bitable/config/list',
    method: 'get',
    params: query
  })
}

// 查询多维格应用配置详细
export function getConfig(id) {
  return request({
    url: '/bitable/config/' + id,
    method: 'get'
  })
}

// 新增多维格应用配置
export function addConfig(data) {
  return request({
    url: '/bitable/config',
    method: 'post',
    data: data
  })
}

// 修改多维格应用配置
export function updateConfig(data) {
  return request({
    url: '/bitable/config',
    method: 'put',
    data: data
  })
}

// 删除多维格应用配置
export function delConfig(id) {
  return request({
    url: '/bitable/config/' + id,
    method: 'delete'
  })
}
