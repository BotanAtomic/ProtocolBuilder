package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameContextActorInformations extends Object implements INetworkType {

    private int protocolId = 150;
    private Number contextualId = 0;
    private EntityLook look;
    private EntityDispositionInformations disposition;
    private FuncTree _looktree;
    private FuncTree _dispositiontree;


    public int getTypeId() {
         return 150;
    }

    public GameContextActorInformations initGameContextActorInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3) {
         this.contextualId = param1;
         this.look = param2;
         this.disposition = param3;
         return this;
    }

    public void reset() {
         this.contextualId = 0;
         this.look = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameContextActorInformations(param1);
    }

    public void serializeAs_GameContextActorInformations(ICustomDataOutput param1) {
         if(this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
         }
         param1.writeDouble(this.contextualId);
         this.look.serializeAs_EntityLook(param1);
         param1.writeShort(this.disposition.getTypeId());
         this.disposition.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextActorInformations(param1);
    }

    public void deserializeAs_GameContextActorInformations(ICustomDataInput param1) {
         this._contextualIdFunc(param1);
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations,_loc2_);
         this.disposition.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextActorInformations(param1);
    }

    public void deserializeAsyncAs_GameContextActorInformations(FuncTree param1) {
         param1.addChild(this._contextualIdFunc);
         this._looktree = param1.addChild(this._looktreeFunc);
         this._dispositiontree = param1.addChild(this._dispositiontreeFunc);
    }

    private void _contextualIdFunc(ICustomDataInput param1) {
         this.contextualId = param1.readDouble();
         if(this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.contextualId + ") on element of GameContextActorInformations.contextualId.");
         }
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

    private void _dispositiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations,_loc2_);
         this.disposition.deserializeAsync(this._dispositiontree);
    }

}