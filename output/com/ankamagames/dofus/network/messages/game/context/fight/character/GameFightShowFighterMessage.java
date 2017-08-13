package com.ankamagames.dofus.network.messages.game.context.fight.character;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameFightShowFighterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5864;
    private boolean _isInitialized = false;
    private GameFightFighterInformations informations;
    private FuncTree _informationstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5864;
    }

    public GameFightShowFighterMessage initGameFightShowFighterMessage(GameFightFighterInformations param1) {
         this.informations = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.informations = new GameFightFighterInformations();
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
         this.serializeAs_GameFightShowFighterMessage(param1);
    }

    public void serializeAs_GameFightShowFighterMessage(ICustomDataOutput param1) {
         param1.writeShort(this.informations.getTypeId());
         this.informations.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightShowFighterMessage(param1);
    }

    public void deserializeAs_GameFightShowFighterMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc2_);
         this.informations.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightShowFighterMessage(param1);
    }

    public void deserializeAsyncAs_GameFightShowFighterMessage(FuncTree param1) {
         this._informationstree = param1.addChild(this._informationstreeFunc);
    }

    private void _informationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc2_);
         this.informations.deserializeAsync(this._informationstree);
    }

}