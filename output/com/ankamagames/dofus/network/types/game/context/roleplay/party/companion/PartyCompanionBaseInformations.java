package package com.ankamagames.dofus.network.types.game.context.roleplay.party.companion;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyCompanionBaseInformations extends Object implements INetworkType {

    private int protocolId = 453;
    private int indexId = 0;
    private int companionGenericId = 0;
    private EntityLook entityLook = ;
    private FuncTree _entityLooktree = ;


    public int getTypeId() {
         return 453;
    }

    public PartyCompanionBaseInformations initPartyCompanionBaseInformations(int param1,int  param2,EntityLook  param3) {
         this.indexId = param1;
         this.companionGenericId = param2;
         this.entityLook = param3;
         return this;
    }

    public void reset() {
         this.indexId = 0;
         this.companionGenericId = 0;
         this.entityLook = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyCompanionBaseInformations(param1);
    }

    public void serializeAs_PartyCompanionBaseInformations(ICustomDataOutput param1) {
         if(this.indexId < 0)
            throw new Exception("Forbidden value (" + this.indexId + ") on element indexId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyCompanionBaseInformations(param1);
    }

    public void deserializeAs_PartyCompanionBaseInformations(ICustomDataInput param1) {
         this._indexIdFunc(param1);
         this._companionGenericIdFunc(param1);
         this.entityLook = new EntityLook();
         this.entityLook.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyCompanionBaseInformations(param1);
    }

    public void deserializeAsyncAs_PartyCompanionBaseInformations(FuncTree param1) {
         param1.addChild(this._indexIdFunc);
         param1.addChild(this._companionGenericIdFunc);
         this._entityLooktree = param1.addChild(this._entityLooktreeFunc);
    }

    private void _indexIdFunc(ICustomDataInput param1) {
         this.indexId = param1.readByte();
         if(this.indexId < 0)
            throw new Exception("Forbidden value (" + this.indexId + ") on element of PartyCompanionBaseInformations.indexId.");
    }

    private void _companionGenericIdFunc(ICustomDataInput param1) {
         this.companionGenericId = param1.readByte();
         if(this.companionGenericId < 0)
            throw new Exception("Forbidden value (" + this.companionGenericId + ") on element of PartyCompanionBaseInformations.companionGenericId.");
    }

    private void _entityLooktreeFunc(ICustomDataInput param1) {
         this.entityLook = new EntityLook();
         this.entityLook.deserializeAsync(this._entityLooktree);
    }

}