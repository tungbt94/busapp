package com.tungbt94.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/*
 * class xu ly viec tim duong
 * Các tuyến xe bus gồm có:

 Xe 32, đi qua các điểm sau: Nhổn-Cầu Diễn-Hồ Tùng Mậu-ĐH Quốc Gia Hà Nội-Cầu Giấy-Hùng Vương-Giáp Bát

 Xe 29, đi qua các điểm sau: Nhổn-Cầu Diễn-Hồ Tùng Mậu-Bến Xe Mỹ Đình-Nguyễn Trãi-Giáp Bát

 Xe 27, đi qua các điểm sau: ĐH Quốc Gia Hà Nội-Hoàng Quốc Việt-Lê Văn Lương-Nguyễn Trãi-HV Bưu Chính

 Xe 39, đi qua các điểm sau: ĐH Quốc Gia Hà Nội, Bến Xe Mỹ Đình, Khuất Duy Tiến, Nguyễn Trãi, HV Bưu Chính

 Xe 05, đi qua BC Thăng Long, Khuất Duy tiến, Bến Xe Mỹ Đình, Hồ Tùng Mậu, Đường K3, HV Cảnh Sát
 Nhổn-Cầu Diễn-Hồ Tùng Mậu-ĐH Quốc Gia Hà Nội-Cầu Giấy-Hùng Vương-Giáp Bát-Bến Xe Mỹ Đình-Nguyễn Trãi-Hoàng Quốc Việt-Lê Văn Lương-
 HV Bưu Chính-Đường K3-HV Cảnh Sát -  Khuất Duy Tiến -BC Thăng Long
 * */

public class Bus {
	private int[][] way;// ma tran duong di
	private String start;// diem dau
	private String end;// diem cuoi
	private String journey;// hanh trinh
	public static final int NUMBER_POSITION = 16;
	public static final int NUMBER_BUS = 5;

	public Bus() {
		initWay();
	}

	// khoi tao ma tran duong di
	public void initWay() {
		int[][] matrixWay = {
				{ 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },// 32
				{ 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },// 29
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },// 27
				{ 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0 },// 39
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1 } // 05
		};
		way = matrixWay;
	}

	// get/set diem dau cuoi
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getPositionOfPlace(String place) {
		switch (place) {
		case "Nhổn":
			return 0;
		case "Cầu Diễn":
			return 1;
		case "Hồ Tùng Mậu":
			return 2;
		case "ĐH Quốc gia":
			return 3;
		case "Cầu Giấy":
			return 4;
		case "Hùng Vương":
			return 5;
		case "Giáp Bát":
			return 6;
		case "Bến xe Mỹ Đình":
			return 7;
		case "Nguyễn Trãi":
			return 8;
		case "Hoàng Quốc Việt":
			return 9;
		case "Lê Văn Lương":
			return 10;
		case "PTIT":
			return 11;
		case "Khuất Duy Tiến":
			return 12;
		case "BigC":
			return 13;
		case "Đường K3":
			return 14;
		case "HV Cảnh Sát":
			return 15;
		default:
			return 0;
		}
	}

	public String getPlaceFromPosition(int position) {
		switch (position) {
		case 0:
			return "Nhổn";
		case 1:
			return "Cầu Diễn";
		case 2:
			return "Hồ Tùng Mậu";
		case 3:
			return "ĐH Quốc gia";
		case 4:
			return "Cầu Giấy";
		case 5:
			return "Hùng Vương";
		case 6:
			return "Giáp Bát";
		case 7:
			return "Bến xe Mỹ Đình";
		case 8:
			return "Nguyễn Trãi";
		case 9:
			return "Hoàng Quốc Việt";
		case 10:
			return "Lê Văn Lương";
		case 11:
			return "PTIT";
		case 12:
			return "Khuất Duy Tiến";
		case 13:
			return "BigC";
		case 14:
			return "Đường K3";
		case 15:
			return "HV Cảnh Sát";
		default:
			return "Địa điểm mới";
		}
	}

	public String getBusNameFromBusNumber(int busNumber) {
		switch (busNumber) {
		case 0:
			return "xe 32";
		case 1:
			return "xe 29";
		case 2:
			return "xe 27";
		case 3:
			return "xe 39";
		case 4:
			return "xe 05";
		default:
			return "xe mới";
		}
	}

	// tim duong di
	public void getJourney() {
		// chuyen diem bat dau, ket thuc bang so
		int startPosition = getPositionOfPlace(start);
		int endPosition = getPositionOfPlace(end);
		// System.out.println("start: " + startPosition+"\nend: "+endPosition);

		// tim cac duong di tu diem dau
		ArrayList<Integer> arrBusNumberToStart = new ArrayList<Integer>();
		for (int i = 0; i < NUMBER_BUS; i++) {
			if (way[i][startPosition] == 1)
				arrBusNumberToStart.add(i);
		}

		// tao danh sach cac cach di
		ArrayList<String> arrWayOfJourney = new ArrayList<String>();
		// tu moi diem dau tim 1 duong di den diem cuoi va add vao danh sach
		// cach di
		for (int busNumber : arrBusNumberToStart) {
			//dung bfs
//			arrWayOfJourney.add(bfsForBusApp(busNumber, startPosition,
//					endPosition));
			//dung dfs
			arrWayOfJourney.add(dfsForBusApp(busNumber, startPosition,
					endPosition));
		}

		System.out.println("Để đi từ " + start + " đến " + end + " ta có "
				+ arrWayOfJourney.size() + " cách:\n");
		for (String strWay : arrWayOfJourney)
			System.out.println(strWay);
	}

	/*
	 * Ham tim duong di bang bfs bfs giup tim duong di it phai chuyen bus nhat
	 */
	public String bfsForBusApp(int busNumber, int startPosition, int endPosition) {
		// System.out.println("start bfs: "+busNumber+" "+startPosition+" "+endPosition);
		// khoi tao ket qua
		String resultWay = "";
		// khoi tao hashmap luu duong di
		HashMap hmWay = new HashMap();
		hmWay.put(busNumber, startPosition);

		// khoi tao ma tran trang thai
		int[] statusPosition = new int[NUMBER_POSITION];
		for (int i : statusPosition)
			statusPosition[i] = 0;

		// khoi tao nowBus - xe dang di va Queue cac xe bus du dinh len
		int nowBus = busNumber;
		Queue qBus = new LinkedList<Integer>();

		// bien kiem tra tim duoc diem cuoi chua
		Boolean found = false;

		/*
		 * tim duong khi nao chua di den diem cuoi thi tiep tuc tim tai moi xe
		 * bus, kiem tra cac diem di qua va luu vao ma tran trang thai neu = 1
		 * diem nao qua roi khong xet lai nua neu di het xe bus dang xet ma
		 * khong tim duoc diem cuoi thi xet sang xe bus lan can khong thi xoa xe
		 * trong hmWay di
		 */
		int i;
		while (!found) {
			// System.out.println("now bus = " +nowBus);
			for (i = 0; i < NUMBER_POSITION; i++) {
				if (way[nowBus][i] == 1 && statusPosition[i] == 0) {
					// System.out.println("way["+nowBus+"]["+i+"] = "+
					// way[nowBus][i]);
					statusPosition[i] = 1;
					qBus.add(i);
					hmWay.put(nowBus, i);
					if (i == endPosition) {
						found = true;
						break;
					}
				}
			}
			nowBus = (int) qBus.poll();
		}

		// lay duong di ra
		StringBuilder sbResult = new StringBuilder();
		Set setWay = hmWay.entrySet();
		Iterator iWay = setWay.iterator();
		while (iWay.hasNext()) {
			Entry meWay = (Entry) iWay.next();
			int bus = (int) meWay.getKey();
			int position = (int) meWay.getValue();
			sbResult.append("Đi " + getBusNameFromBusNumber(bus));
			sbResult.append(" đến " + getPlaceFromPosition(position) + "\n");
		}

		// tra ket qua
		resultWay = sbResult.toString();
		return resultWay;
	}

	/*
	 * Ham tim duong di bang dfs
	 */
	public String dfsForBusApp(int busNumber, int startPosition, int endPosition) {
		// System.out.println("start bfs: "+busNumber+" "+startPosition+" "+endPosition);
		// khoi tao ket qua
		String resultWay = "";
		// khoi tao hashmap luu duong di
		HashMap hmWay = new HashMap();
		hmWay.put(busNumber, startPosition);

		// khoi tao ma tran trang thai
		int[] statusPosition = new int[NUMBER_POSITION];
		for (int i : statusPosition)
			statusPosition[i] = 0;

		// khoi tao nowBus - xe dang di va Queue cac xe bus du dinh len
		int nowBus = busNumber;
		Queue qBus = new LinkedList<Integer>();
//		hmWay.put(nowBus, 0);
		
		// bien kiem tra tim duoc diem cuoi chua
		Boolean found = false;

		/*
		 * tim duong khi nao chua di den diem cuoi thi tiep tuc tim tai moi xe
		 * bus, kiem tra cac diem di qua va luu vao ma tran trang thai neu = 1
		 * diem nao qua roi khong xet lai nua
		 * neu di het xe bus dang xet ma khong tim thay diem dung nao = 1 nua thi quay lai xe trc do
		 * */
		int i;
		while(!found){
			for(i = 0; i < NUMBER_POSITION; i++){
				if(way[nowBus][i] == 1 && statusPosition[i]== 0){
					statusPosition[i] = 1;
					hmWay.put(nowBus, i);
					qBus.add(i);
					if (i == endPosition) {
						found = true;
					}
					break;
				}
			}
			if((i== NUMBER_POSITION && found == false) || i >= NUMBER_BUS)
				nowBus = (int) qBus.poll();
			else
				nowBus = i;
			System.out.println("nowBus = "+ nowBus );
		}

		// lay duong di ra
		StringBuilder sbResult = new StringBuilder();
		Set setWay = hmWay.entrySet();
		Iterator iWay = setWay.iterator();
		while (iWay.hasNext()) {
			Entry meWay = (Entry) iWay.next();
			int bus = (int) meWay.getKey();
			int position = (int) meWay.getValue();
			sbResult.append("Đi " + getBusNameFromBusNumber(bus));
			sbResult.append(" đến " + getPlaceFromPosition(position) + "\n");
		}

		// tra ket qua
		resultWay = sbResult.toString();
		return resultWay;
	}
}
