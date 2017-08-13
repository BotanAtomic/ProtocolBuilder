package package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceInsiderPrismInformation extends PrismInformation implements INetworkType {

    private int protocolId = 431;
    private int lastTimeSlotModificationDate = 0;
    private int lastTimeSlotModificationAuthorGuildId = 0;
    private Number lastTimeSlotModificationAuthorId = 0;
    private String lastTimeSlotModificationAuthorName = "";
    private Vector.<ObjectItem> modulesObjects = ;
    private FuncTree _modulesObjectstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 431;
    }

    public AllianceInsiderPrismInformation initAllianceInsiderPrismInformation(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,Number  param8,String  param9,Vector.<ObjectItem>  param10) {
         super.initPrismInformation(param1,param2,param3,param4,param5);
         this.lastTimeSlotModificationDate = param6;
         this.lastTimeSlotModificationAuthorGuildId = param7;
         this.lastTimeSlotModificationAuthorId = param8;
         this.lastTimeSlotModificationAuthorName = param9;
         this.modulesObjects = param10;
         return this;
    }

    public void reset() {
         super.reset();
         this.lastTimeSlotModificationDate = 0;
         this.lastTimeSlotModificationAuthorGuildId = 0;
         this.lastTimeSlotModificationAuthorId = 0;
         this.lastTimeSlotModificationAuthorName = "";
         this.modulesObjects = new Vector.<ObjectItem>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AllianceInsiderPrismInformation(param1);
    }

    public void serializeAs_AllianceInsiderPrismInformation(ICustomDataOutput param1) {
         super.serializeAs_PrismInformation(param1);
         if(this.lastTimeSlotModificationDate < 0)
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationDate + ") on element lastTimeSlotModificationDate.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceInsiderPrismInformation(param1);
    }

    public void deserializeAs_AllianceInsiderPrismInformation(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         super.deserialize(param1);
         this._lastTimeSlotModificationDateFunc(param1);
         this._lastTimeSlotModificationAuthorGuildIdFunc(param1);
         this._lastTimeSlotModificationAuthorIdFunc(param1);
         this._lastTimeSlotModificationAuthorNameFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.modulesObjects.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceInsiderPrismInformation(param1);
    }

    public void deserializeAsyncAs_AllianceInsiderPrismInformation(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._lastTimeSlotModificationDateFunc);
         param1.addChild(this._lastTimeSlotModificationAuthorGuildIdFunc);
         param1.addChild(this._lastTimeSlotModificationAuthorIdFunc);
         param1.addChild(this._lastTimeSlotModificationAuthorNameFunc);
         this._modulesObjectstree = param1.addChild(this._modulesObjectstreeFunc);
    }

    private void _lastTimeSlotModificationDateFunc(ICustomDataInput param1) {
         this.lastTimeSlotModificationDate = param1.readInt();
         if(this.lastTimeSlotModificationDate < 0)
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationDate + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationDate.");
    }

    private void _lastTimeSlotModificationAuthorGuildIdFunc(ICustomDataInput param1) {
         this.lastTimeSlotModificationAuthorGuildId = param1.readVarUhInt();
         if(this.lastTimeSlotModificationAuthorGuildId < 0)
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationAuthorGuildId + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationAuthorGuildId.");
    }

    private void _lastTimeSlotModificationAuthorIdFunc(ICustomDataInput param1) {
         this.lastTimeSlotModificationAuthorId = param1.readVarUhLong();
         if(this.lastTimeSlotModificationAuthorId < 0 || this.lastTimeSlotModificationAuthorId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationAuthorId + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationAuthorId.");
    }

    private void _lastTimeSlotModificationAuthorNameFunc(ICustomDataInput param1) {
         this.lastTimeSlotModificationAuthorName = param1.readUTF();
    }

    private void _modulesObjectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._modulesObjectstree.addChild(this._modulesObjectsFunc);
            _loc3_++;
    }

    private void _modulesObjectsFunc(ICustomDataInput param1) {
         ObjectItem _loc2_ = new ObjectItem();
         _loc2_.deserialize(param1);
         this.modulesObjects.push(_loc2_);
    }

}