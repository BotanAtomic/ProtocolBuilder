package package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockToSellFilterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6161;
    private boolean _isInitialized = false;
    private int areaId = 0;
    private int atLeastNbMount = 0;
    private int atLeastNbMachine = 0;
    private Number maxPrice = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6161;
    }

    public PaddockToSellFilterMessage initPaddockToSellFilterMessage(int param1,int  param2,int  param3,Number  param4) {
         this.areaId = param1;
         this.atLeastNbMount = param2;
         this.atLeastNbMachine = param3;
         this.maxPrice = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.areaId = 0;
         this.atLeastNbMount = 0;
         this.atLeastNbMachine = 0;
         this.maxPrice = 0;
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
         this.serializeAs_PaddockToSellFilterMessage(param1);
    }

    public void serializeAs_PaddockToSellFilterMessage(ICustomDataOutput param1) {
         param1.writeInt(this.areaId);
         param1.writeByte(this.atLeastNbMount);
         param1.writeByte(this.atLeastNbMachine);
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element maxPrice.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockToSellFilterMessage(param1);
    }

    public void deserializeAs_PaddockToSellFilterMessage(ICustomDataInput param1) {
         this._areaIdFunc(param1);
         this._atLeastNbMountFunc(param1);
         this._atLeastNbMachineFunc(param1);
         this._maxPriceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockToSellFilterMessage(param1);
    }

    public void deserializeAsyncAs_PaddockToSellFilterMessage(FuncTree param1) {
         param1.addChild(this._areaIdFunc);
         param1.addChild(this._atLeastNbMountFunc);
         param1.addChild(this._atLeastNbMachineFunc);
         param1.addChild(this._maxPriceFunc);
    }

    private void _areaIdFunc(ICustomDataInput param1) {
         this.areaId = param1.readInt();
    }

    private void _atLeastNbMountFunc(ICustomDataInput param1) {
         this.atLeastNbMount = param1.readByte();
    }

    private void _atLeastNbMachineFunc(ICustomDataInput param1) {
         this.atLeastNbMachine = param1.readByte();
    }

    private void _maxPriceFunc(ICustomDataInput param1) {
         this.maxPrice = param1.readVarUhLong();
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element of PaddockToSellFilterMessage.maxPrice.");
    }

}