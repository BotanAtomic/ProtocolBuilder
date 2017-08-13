package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemGenericQuantity;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeGuildTaxCollectorGetMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5762;
    private boolean _isInitialized = false;
    private String collectorName = "";
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private String userName = "";
    private Number callerId = 0;
    private String callerName = "";
    private Number experience = 0;
    private int pods = 0;
    private Vector.<ObjectItemGenericQuantity> objectsInfos = ;
    private FuncTree _objectsInfostree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5762;
    }

    public ExchangeGuildTaxCollectorGetMessage initExchangeGuildTaxCollectorGetMessage(String param1,int  param2,int  param3,int  param4,int  param5,String  param6,Number  param7,String  param8,Number  param9,int  param10,Vector.<ObjectItemGenericQuantity>  param11) {
         this.collectorName = param1;
         this.worldX = param2;
         this.worldY = param3;
         this.mapId = param4;
         this.subAreaId = param5;
         this.userName = param6;
         this.callerId = param7;
         this.callerName = param8;
         this.experience = param9;
         this.pods = param10;
         this.objectsInfos = param11;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.collectorName = "";
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
         this.userName = "";
         this.callerId = 0;
         this.callerName = "";
         this.experience = 0;
         this.pods = 0;
         this.objectsInfos = new Vector.<ObjectItemGenericQuantity>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ExchangeGuildTaxCollectorGetMessage(param1);
    }

    public void serializeAs_ExchangeGuildTaxCollectorGetMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.collectorName);
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeGuildTaxCollectorGetMessage(param1);
    }

    public void deserializeAs_ExchangeGuildTaxCollectorGetMessage(ICustomDataInput param1) {
         ObjectItemGenericQuantity _loc4_ = null;
         this._collectorNameFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
         this._userNameFunc(param1);
         this._callerIdFunc(param1);
         this._callerNameFunc(param1);
         this._experienceFunc(param1);
         this._podsFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItemGenericQuantity();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeGuildTaxCollectorGetMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeGuildTaxCollectorGetMessage(FuncTree param1) {
         param1.addChild(this._collectorNameFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._userNameFunc);
         param1.addChild(this._callerIdFunc);
         param1.addChild(this._callerNameFunc);
         param1.addChild(this._experienceFunc);
         param1.addChild(this._podsFunc);
         this._objectsInfostree = param1.addChild(this._objectsInfostreeFunc);
    }

    private void _collectorNameFunc(ICustomDataInput param1) {
         this.collectorName = param1.readUTF();
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of ExchangeGuildTaxCollectorGetMessage.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of ExchangeGuildTaxCollectorGetMessage.worldY.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of ExchangeGuildTaxCollectorGetMessage.subAreaId.");
    }

    private void _userNameFunc(ICustomDataInput param1) {
         this.userName = param1.readUTF();
    }

    private void _callerIdFunc(ICustomDataInput param1) {
         this.callerId = param1.readVarUhLong();
         if(this.callerId < 0 || this.callerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.callerId + ") on element of ExchangeGuildTaxCollectorGetMessage.callerId.");
    }

    private void _callerNameFunc(ICustomDataInput param1) {
         this.callerName = param1.readUTF();
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readDouble();
         if(this.experience < -9.007199254740992E15 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of ExchangeGuildTaxCollectorGetMessage.experience.");
    }

    private void _podsFunc(ICustomDataInput param1) {
         this.pods = param1.readVarUhShort();
         if(this.pods < 0)
            throw new Exception("Forbidden value (" + this.pods + ") on element of ExchangeGuildTaxCollectorGetMessage.pods.");
    }

    private void _objectsInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectsInfostree.addChild(this._objectsInfosFunc);
            _loc3_++;
    }

    private void _objectsInfosFunc(ICustomDataInput param1) {
         ObjectItemGenericQuantity _loc2_ = new ObjectItemGenericQuantity();
         _loc2_.deserialize(param1);
         this.objectsInfos.push(_loc2_);
    }

}