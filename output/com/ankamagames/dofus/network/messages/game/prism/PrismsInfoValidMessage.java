package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.prism.PrismFightersInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismsInfoValidMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6451;
    private boolean _isInitialized = false;
    private Vector<PrismFightersInformation> fights;
    private FuncTree _fightstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6451;
    }

    public PrismsInfoValidMessage initPrismsInfoValidMessage(Vector<PrismFightersInformation> param1) {
         this.fights = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fights = new Vector.<PrismFightersInformation>();
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
         this.serializeAs_PrismsInfoValidMessage(param1);
    }

    public void serializeAs_PrismsInfoValidMessage(ICustomDataOutput param1) {
         param1.writeShort(this.fights.length);
         int _loc2_ = 0;
         while(_loc2_ < this.fights.length)
         {
            (this.fights[_loc2_] as PrismFightersInformation).serializeAs_PrismFightersInformation(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismsInfoValidMessage(param1);
    }

    public void deserializeAs_PrismsInfoValidMessage(ICustomDataInput param1) {
         PrismFightersInformation _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PrismFightersInformation();
            _loc4_.deserialize(param1);
            this.fights.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismsInfoValidMessage(param1);
    }

    public void deserializeAsyncAs_PrismsInfoValidMessage(FuncTree param1) {
         this._fightstree = param1.addChild(this._fightstreeFunc);
    }

    private void _fightstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._fightstree.addChild(this._fightsFunc);
            _loc3_++;
         }
    }

    private void _fightsFunc(ICustomDataInput param1) {
         PrismFightersInformation _loc2_ = new PrismFightersInformation();
         _loc2_.deserialize(param1);
         this.fights.push(_loc2_);
    }

}