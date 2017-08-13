package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInstanceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HousePropertiesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5734;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private Vector.<uint> doorsOnMap = ;
    private HouseInstanceInformations properties = ;
    private FuncTree _doorsOnMaptree = ;
    private FuncTree _propertiestree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5734;
    }

    public HousePropertiesMessage initHousePropertiesMessage(int param1,Vector.<uint>  param2,HouseInstanceInformations  param3) {
         this.houseId = param1;
         this.doorsOnMap = param2;
         this.properties = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.doorsOnMap = new Vector.<uint>();
         this.properties = new HouseInstanceInformations();
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
         this.serializeAs_HousePropertiesMessage(param1);
    }

    public void serializeAs_HousePropertiesMessage(ICustomDataOutput param1) {
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HousePropertiesMessage(param1);
    }

    public void deserializeAs_HousePropertiesMessage(ICustomDataInput param1) {
         int _loc5_ = 0;
         this._houseIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc5_ = param1.readInt();
            if(_loc5_ < 0)
               throw new Exception("Forbidden value (" + _loc5_ + ") on elements of doorsOnMap.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HousePropertiesMessage(param1);
    }

    public void deserializeAsyncAs_HousePropertiesMessage(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         this._doorsOnMaptree = param1.addChild(this._doorsOnMaptreeFunc);
         this._propertiestree = param1.addChild(this._propertiestreeFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HousePropertiesMessage.houseId.");
    }

    private void _doorsOnMaptreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._doorsOnMaptree.addChild(this._doorsOnMapFunc);
            _loc3_++;
    }

    private void _doorsOnMapFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of doorsOnMap.");
    }

    private void _propertiestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.properties = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.properties.deserializeAsync(this._propertiestree);
    }

}