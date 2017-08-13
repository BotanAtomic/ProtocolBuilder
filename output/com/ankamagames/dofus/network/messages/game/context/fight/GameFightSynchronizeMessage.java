package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameFightSynchronizeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5921;
    private boolean _isInitialized = false;
    private Vector<GameFightFighterInformations> fighters;
    private FuncTree _fighterstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5921;
    }

    public GameFightSynchronizeMessage initGameFightSynchronizeMessage(Vector<GameFightFighterInformations> param1) {
         this.fighters = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fighters = new Vector.<GameFightFighterInformations>();
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
         this.serializeAs_GameFightSynchronizeMessage(param1);
    }

    public void serializeAs_GameFightSynchronizeMessage(ICustomDataOutput param1) {
         param1.writeShort(this.fighters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.fighters.length)
         {
            param1.writeShort((this.fighters[_loc2_] as GameFightFighterInformations).getTypeId());
            (this.fighters[_loc2_] as GameFightFighterInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightSynchronizeMessage(param1);
    }

    public void deserializeAs_GameFightSynchronizeMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         GameFightFighterInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.fighters.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightSynchronizeMessage(param1);
    }

    public void deserializeAsyncAs_GameFightSynchronizeMessage(FuncTree param1) {
         this._fighterstree = param1.addChild(this._fighterstreeFunc);
    }

    private void _fighterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._fighterstree.addChild(this._fightersFunc);
            _loc3_++;
         }
    }

    private void _fightersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GameFightFighterInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.fighters.push(_loc3_);
    }

}