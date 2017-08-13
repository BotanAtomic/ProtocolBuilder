package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
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

public class PrismFightAttackerRemoveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5897;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int fightId = 0;
    private Number fighterToRemoveId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5897;
    }

    public PrismFightAttackerRemoveMessage initPrismFightAttackerRemoveMessage(int param1,int  param2,Number  param3) {
         this.subAreaId = param1;
         this.fightId = param2;
         this.fighterToRemoveId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.subAreaId = 0;
         this.fightId = 0;
         this.fighterToRemoveId = 0;
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
         this.serializeAs_PrismFightAttackerRemoveMessage(param1);
    }

    public void serializeAs_PrismFightAttackerRemoveMessage(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeVarShort(this.fightId);
         if(this.fighterToRemoveId < 0 || this.fighterToRemoveId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterToRemoveId + ") on element fighterToRemoveId.");
         }
         param1.writeVarLong(this.fighterToRemoveId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismFightAttackerRemoveMessage(param1);
    }

    public void deserializeAs_PrismFightAttackerRemoveMessage(ICustomDataInput param1) {
         this._subAreaIdFunc(param1);
         this._fightIdFunc(param1);
         this._fighterToRemoveIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismFightAttackerRemoveMessage(param1);
    }

    public void deserializeAsyncAs_PrismFightAttackerRemoveMessage(FuncTree param1) {
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._fighterToRemoveIdFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightAttackerRemoveMessage.subAreaId.");
         }
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readVarUhShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of PrismFightAttackerRemoveMessage.fightId.");
         }
    }

    private void _fighterToRemoveIdFunc(ICustomDataInput param1) {
         this.fighterToRemoveId = param1.readVarUhLong();
         if(this.fighterToRemoveId < 0 || this.fighterToRemoveId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterToRemoveId + ") on element of PrismFightAttackerRemoveMessage.fighterToRemoveId.");
         }
    }

}