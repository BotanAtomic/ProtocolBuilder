package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayRemoveChallengeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 300;
    private boolean _isInitialized = false;
    private int fightId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 300;
    }

    public GameRolePlayRemoveChallengeMessage initGameRolePlayRemoveChallengeMessage(int param1) {
         this.fightId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
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
         this.serializeAs_GameRolePlayRemoveChallengeMessage(param1);
    }

    public void serializeAs_GameRolePlayRemoveChallengeMessage(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayRemoveChallengeMessage(param1);
    }

    public void deserializeAs_GameRolePlayRemoveChallengeMessage(ICustomDataInput param1) {
         this._fightIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayRemoveChallengeMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayRemoveChallengeMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

}