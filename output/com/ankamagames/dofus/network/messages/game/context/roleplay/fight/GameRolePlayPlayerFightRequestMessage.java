package package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayPlayerFightRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5731;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int targetCellId = 0;
    private boolean friendly = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5731;
    }

    public GameRolePlayPlayerFightRequestMessage initGameRolePlayPlayerFightRequestMessage(Number param1,int  param2,boolean  param3) {
         this.targetId = param1;
         this.targetCellId = param2;
         this.friendly = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.targetId = 0;
         this.targetCellId = 0;
         this.friendly = false;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_GameRolePlayPlayerFightRequestMessage(param1);
    }

    public void serializeAs_GameRolePlayPlayerFightRequestMessage(ICustomDataOutput param1) {
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayPlayerFightRequestMessage(param1);
    }

    public void deserializeAs_GameRolePlayPlayerFightRequestMessage(ICustomDataInput param1) {
         this._targetIdFunc(param1);
         this._targetCellIdFunc(param1);
         this._friendlyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayPlayerFightRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayPlayerFightRequestMessage(FuncTree param1) {
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._targetCellIdFunc);
         param1.addChild(this._friendlyFunc);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readVarUhLong();
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameRolePlayPlayerFightRequestMessage.targetId.");
    }

    private void _targetCellIdFunc(ICustomDataInput param1) {
         this.targetCellId = param1.readShort();
         if(this.targetCellId < -1 || this.targetCellId > 559)
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element of GameRolePlayPlayerFightRequestMessage.targetCellId.");
    }

    private void _friendlyFunc(ICustomDataInput param1) {
         this.friendly = param1.readBoolean();
    }

}