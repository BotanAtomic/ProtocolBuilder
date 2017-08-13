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

public class GameRolePlayFightRequestCanceledMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5822;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private Number sourceId = 0;
    private Number targetId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5822;
    }

    public GameRolePlayFightRequestCanceledMessage initGameRolePlayFightRequestCanceledMessage(int param1,Number  param2,Number  param3) {
         this.fightId = param1;
         this.sourceId = param2;
         this.targetId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.sourceId = 0;
         this.targetId = 0;
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
         this.serializeAs_GameRolePlayFightRequestCanceledMessage(param1);
    }

    public void serializeAs_GameRolePlayFightRequestCanceledMessage(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayFightRequestCanceledMessage(param1);
    }

    public void deserializeAs_GameRolePlayFightRequestCanceledMessage(ICustomDataInput param1) {
         this._fightIdFunc(param1);
         this._sourceIdFunc(param1);
         this._targetIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayFightRequestCanceledMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayFightRequestCanceledMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._sourceIdFunc);
         param1.addChild(this._targetIdFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

    private void _sourceIdFunc(ICustomDataInput param1) {
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of GameRolePlayFightRequestCanceledMessage.sourceId.");
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameRolePlayFightRequestCanceledMessage.targetId.");
    }

}